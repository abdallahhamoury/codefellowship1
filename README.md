# codefellowship
### Labs 16 : CodeFellowship Login, Profiles & Posts
#### Feature Tasks

Build an app that allows users to create their profile on CodeFellowship
- The site must have a starting page in the root path (/) that contains basic information about the site, as well as a link to the "Registration" page. ApplicationUser must have a username, password (which will be hashed with BCrypt), first and last name Date of birth, CV and any other fields you think are useful.
- The site should be well-designed and attractive. The site should have a non-white-label error handling page that allows the user to know the error code and at least a brief message about the error that occurred.
  The site should use reusable forms for its information. (At a minimum, it should contain one part of a Thymeleaf paper to be used on multiple pages.)
- The site must allow users to create an Application User on the Registration page.
  Your console must have an Autowired Private PasswordEncoder passwordEncoder; And use that to run the site must have a page that allows data about a single user of the app to be displayed, on a path like /users/{id}passwordEncoder.encode(the password) before the password is saved in the new user.
- Make sure that user registration also automatically logs users into your app.
  Add the Post entity to your app.
  The post has text and timestamp generated.
  The logged in user must be able to create a post, and the post must belong to the user who created it.
  Hint: This is a relationship between two pieces of data
  User posts must be visible on their profile page.
- The site must have a page that allows data about a single user of the app to be displayed, on a path like /users/{id}.
  This should include the default profile picture, which is the same for each user, and their basic information.
  Using the cheat sheet above, add the ability for users to log into your app.
  When the user is logged in, the app should display the user's username on each page (maybe in the title).