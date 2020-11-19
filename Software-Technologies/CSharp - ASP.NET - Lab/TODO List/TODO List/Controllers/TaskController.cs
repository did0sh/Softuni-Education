using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using TODO_List.Models;

namespace TODO_List.Controllers
{
    public class TaskController : Controller
    {
        [HttpPost]
        public ActionResult Create(Task task)
        {
            if (task == null)
            {
                return RedirectToAction("Index", "Home");
            }

            using (var db = new TaskDbContext())
            {
                db.Tasks.Add(task);
                db.SaveChanges();
            }

            return RedirectToAction("Index", "Home");
        }

        [HttpGet]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return RedirectToAction("Index", "Home");
            }

            using (var db = new TaskDbContext())
            {
                var findId = db.Tasks.Find(id);

                if (findId == null)
                {
                    return RedirectToAction("Index", "Home");
                }
                db.Tasks.Remove(findId);
                db.SaveChanges();
            }

            return RedirectToAction("Index", "Home");
        }


    }
}