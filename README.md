# CodeFellowship Login, Profiles & Posts

### Feature Tasks

- an app that allows users to create their profile on CodeFellowship.

- The site have a splash page at the root route `(/)` that contains basic information about the site, as well as a link to the “sign up” page.

- An `ApplicationUser` have a username, password (hashed using BCrypt), firstName, lastName, dateOfBirth, bio.

- The site allow users to create an ApplicationUser on the “sign up” page.

- Controller have an `@Autowired` private PasswordEncoder passwordEncoder.

- The site have a page which allows viewing the data about a single ApplicationUser, at a route like `/profile`.

- This include a default profile picture, which is the same for every user, and their basic information.

- When a user is logged in, the app display the user’s username on every page.

- homepage, login, and registration routes are accessible to non-logged in users. All other routes are limited to logged-in users.

- The site use reusable templates for its information.

- The site have a non-whitelabel error handling page that lets the user know, at minimum, the error code and a brief message about what went wrong.

- Post entity has a body and a createdAt timestamp.

- A logged-in user able to create a Post, and a post should belong to the user that created it.

- A user’s posts visible on their profile page.

- users can follow other users.

- index page `"/"` where a user can discover other users on the service.

- On a user profile page that does NOT belong to the currently logged-in user, there is a “Follow” button. When a user clicks that follow button, the logged-in user is now following the viewed-profile-page user.

- note: this will require a self-join on ApplicationUsers.

- A user can visit a url `(/feed)` to view all of the posts from the users that they follow.

- Each post have a link to the user profile of the user who wrote the post.

### To Run The App

- Edit the username and password application.properties
