function main() {
    class Post{
        constructor(title, content){
            this.title = title;
            this.content = content;
        }

        toString(){
            return `Post: ${this.title}\nContent: ${this.content}`;
        }
    }

    class SocialMediaPost extends Post{
        constructor(title, content, likes, dislikes){
            super(title, content);
            this.likes = Number(likes);
            this.dislikes = Number(dislikes);
            this.comments = [];
        }

        addComment(comment){
            this.comments.push(comment);
        }

        toString(){
            let strBefore = super.toString();
            let currentOutput = `\nRating: ${this.likes - this.dislikes}`;
            if(this.comments.length > 0){
                currentOutput += `\nComments:`;
                for (let comment of this.comments) {
                    currentOutput += `\n * ${comment}`;
                }
            }
            return strBefore + currentOutput;
        }
    }

    class BlogPost extends Post{
        constructor(title, content, views){
            super(title, content);
            this.views = Number(views);
        }

        view(){
            this.views++;
            return this;
        }

        toString(){
            let addStr = `\nViews: ${this.views}`;
            return super.toString() + addStr;
        }
    }

    return{
        Post, SocialMediaPost, BlogPost
    }
}



let post = new Post("Post", "Content");

console.log(post.toString());

// Post: Post
// Content: Content

let scm = new SocialMediaPost("TestTitle", "TestContent", 25, 30);

scm.addComment("Good post");
scm.addComment("Very good post");
scm.addComment("Wow!");

console.log(scm.toString());

// Post: TestTitle
// Content: TestContent
// Rating: -5
// Comments:
//  * Good post
//  * Very good post
//  * Wow!
