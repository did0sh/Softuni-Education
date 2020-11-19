using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using BlogCSharp.Models;

namespace BlogCSharp.Controllers
{
    public class ArticleController : Controller
    {
        // GET: Article
        public ActionResult Index()
        {
            return RedirectToAction("List", "Article");
        }

        public ActionResult List()
        {
            using (var database = new BlogDbContext())
            {
                var articles = database.Articles.Include(a => a.Author).ToList();
                return View(articles);
            }
            
        }

        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new BlogDbContext())
            {
                var article = database.Articles.Where(a => a.Id == id).Include(a => a.Author).First();
                if (article == null)
                {
                    return HttpNotFound();
                }

                return View(article);
            }
        }

        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Authorize]
        public ActionResult Create(Article article)
        {
            if (ModelState.IsValid)
            {
                using (var database = new BlogDbContext())
                {
                    var authorId = database.Users
                        .Where(u => u.UserName == this.User.Identity.Name)
                        .First()
                        .Id;

                    article.AuthorId = authorId;

                    database.Articles.Add(article);
                    database.SaveChanges();

                    return RedirectToAction("Index");
                }
            }
            return View(article);
        }

        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new BlogDbContext())
            {
                // get article from database
                var article = database.Articles.Where(a => a.Id == id).Include(a => a.Author).First();

                if (!isAuthorizedToEdit(article))
                {
                    return new HttpStatusCodeResult(HttpStatusCode.Forbidden);
                }

                //check if article exists
                if (article == null)
                {
                    return HttpNotFound();
                }

                //pass article to view
                return View(article);
            }
        }

        [HttpPost]
        [ActionName("Delete")]
       
        public ActionResult DeleteConfirmed(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new BlogDbContext())
            {
                var article = database.Articles.Where(a => a.Id == id).Include(a => a.Author).First();
                if (article == null)
                {
                    return HttpNotFound();
                }

                database.Articles.Remove(article);
                database.SaveChanges();

                return RedirectToAction("Index");
            }
            
        }

        public ActionResult Edit(int? id)
        {
            using (var db = new BlogDbContext())
            {
                //Get article from database
                var article = db.Articles.Where(a => a.Id == id).First();

                if (!isAuthorizedToEdit(article))
                {
                    return new HttpStatusCodeResult(HttpStatusCode.Forbidden);
                }

                //Check if article exists
                if (article == null)
                {
                    return HttpNotFound();
                }

                //create new article model
                var model = new ArticleViewModel();
                model.Title = article.Title;
                model.Id = article.Id;
                model.Content = article.Content;

                //pass it to the view
                return View(model);
            }
            
        }

        [HttpPost]
        public ActionResult Edit(ArticleViewModel model)
        {
            if (ModelState.IsValid)
            {
                //Get article from database
                using (var db = new BlogDbContext())
                {
                    var article = db.Articles.FirstOrDefault(a => a.Id == model.Id);

                    //Set article properties
                    article.Title = model.Title;
                    article.Content = model.Content;

                    // Save Article state in database
                    db.Entry(article).State = EntityState.Modified;
                    db.SaveChanges();

                    return RedirectToAction("Index");
                }

            }

            return View(model);
        }

        private bool isAuthorizedToEdit(Article article)
        {
            bool isAdmin = this.User.IsInRole("Admin");
            bool isAuthor = article.isAuthor(this.User.Identity.Name);

            return isAdmin || isAuthor;
        }
    }
}