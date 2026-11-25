# myweb: Project Report (handoff for a new AI mentor)

_Last updated: 2026-11-24_

## 1. Who I am and how we work

- I'm a **beginner learning core Java** (fundamentals done: classes, objects, enums, lists, loops). GitHub: `devruz`.
- I'm building my personal website in Java **while learning**, so the website is also my practice project.
- **Working style: mentor mode.** You act as my senior software engineer:
  - Give me **one small task at a time**, often as a code template with `___` blanks for me to fill.
  - **I write the code myself.** Don't write full solutions unless I'm really stuck.
  - Then **review my code**: point out bugs, explain why, and give the next task.
  - Explain new concepts simply (analogies help), and give terminal commands **one at a time** with what output to expect.
  - I sometimes ask for a line-by-line explanation before writing code. Please do that.

## 2. The website design

### Home page layout (my sketch)

```
+-----------------------------------------------------------------------------------+
| Home                      SWE  Study  Projects  Gallery  Cooking  Gym  Blog  Startups |
|  +-----------------------------+                                                  |
|  |  (photo)     About me       |        (right side: latest posts / highlights)   |
|  |  links to my profiles       |                                                  |
|  |  resume (download)          |                                                  |
|  +-----------------------------+                                                  |
+-----------------------------------------------------------------------------------+
```

- Top-left: "Home" link. Top-right: navigation menu to all sections.
- Left card: profile photo, short "About me", links to my profiles (GitHub, LinkedIn, LeetCode, Telegram...), resume download (PDF).

### Chosen visual style: "Option A, black letters" + light/night mode

Mockups: https://claude.ai/artifact/1aTGu19ofM8muFEhqWswi9 (private link, only I can open it; the top one is the chosen design with a working Night mode button). Everything needed to build it is described below.

- Font: **Inter** (Google Fonts), fallback `system-ui, sans-serif`. Weights 400/500/600/700.
- Light mode: white background `#ffffff`, **all text black `#000`**, profile card `#f8fafc` with `#e3e8ef` border and rounded corners (14px), tiles with `#e3e8ef` border.
- Night mode: background `#0f1115`, text `#f2f2f2`, card `#181b21`, borders `#2a2e36`.
- One accent color only: blue `#2f6fed` (night: `#6d9bff`), used just for the resume button and a thin underline under the current menu item.
- A "Night mode / Light mode" button sits at the right end of the top menu. Plan: CSS variables on `:root`, a `.night` (or `data-theme="dark"`) class on `<html>` that swaps them, a small JavaScript click handler, and `localStorage` to remember the choice.

### Sections

| Section | What it is |
|---|---|
| Home | Photo, about me, profile links, resume |
| SWE | My software engineering career and experience (jobs, internships, roles) as a timeline |
| Study | My education, awards and achievements, certificates |
| Projects | My projects. Visitors can **run and watch** them: live demo (embedded or link), demo video, screenshots, GitHub link |
| Gallery | Pictures from my life, posted randomly whenever I want |
| Cooking | My cooking posts (recipe, photos, story) |
| Gym | Workouts, muscle groups, progress (lifts, body weight) with charts. **Currently being built** |
| Blog | Posts about my engineering experience |
| Startups | My startups and my investments, with write-ups |

Only I (admin) can add/edit content. Visitors can only read and view.

## 3. Planned architecture

- **One Spring Boot app (monolith)** with one package per section.
- Each section uses the same pattern: **Entity → Repository → Service → Controller → Template**.
  - `XxxApiController` (`@RestController`) returns JSON at `/api/...`
  - `XxxPageController` (`@Controller`) returns Thymeleaf HTML pages.
- **Frontend:** Thymeleaf HTML + CSS + a little JavaScript (charts). Shared header/menu via Thymeleaf fragments.
- **Database (later):** PostgreSQL with Spring Data JPA. Data is currently **in memory** (Java lists).
- **Files:** photos/videos/resume on disk (`uploads/`) at first, cloud storage later.
- **Admin panel + login (later):** Spring Security, only I can open `/admin`.
- **Deploy (later):** Docker on a cloud server, domain and HTTPS.

## 4. Tech setup

- Java **21**, **Spring Boot 4.2.0**, Maven (`mvnw`), IntelliJ IDEA, Git on Windows.
- Dependencies now: `spring-boot-starter-webmvc`, `spring-boot-starter-thymeleaf`, `spring-boot-devtools` (+ test starters).
- Local folder: `D:\myweb\myweb`. Repo: https://github.com/devruz/myweb, branch `main`.
- App runs on **port 8084** (`server.port=8084` in `application.properties`).
- Base package: `com.devruz.myweb`.

## 5. Current code (what exists now)

```
src/main/java/com/devruz/myweb/
  MywebApplication.java      # Spring Boot main class
  HomeController.java        # @Controller, GET "/" -> templates/index.html
  gym/
    MuscleGroup.java         # enum: CHEST, SHOULDERS, TRAPS, TRICEPS, BICEPS, FOREARMS,
                             #       ABS, BACK, QUADRICEPS, GLUTES, HAMSTRINGS, CALVES
    Workout.java             # fields: exercise, muscleGroup, sets, reps, weightKg (+ getters/setters)
    WorkoutService.java      # @Service, in-memory List<Workout> (~38 exercises filled in constructor)
                             #   getAll(), getByMuscle(MuscleGroup)
    WorkoutController.java   # @RestController
                             #   GET /api/workouts                 -> all workouts (JSON)
                             #   GET /api/workouts/muscle/{muscle} -> filtered by muscle (@PathVariable)
src/main/resources/
  application.properties     # app name + port 8084
  templates/index.html       # simple "Hello" heading
  templates/about.html       # empty placeholder
```

Working URLs:
- http://localhost:8084/ : home page
- http://localhost:8084/api/workouts : all workouts as JSON
- http://localhost:8084/api/workouts/muscle/CHEST : one muscle (enum name must be CAPITALS)

## 6. Progress so far

1. Task 1 done: JDK, IntelliJ, Git, GitHub repo `myweb`.
2. Hello page (`HomeController` + `index.html`).
3. Gym model: `Workout` class and `MuscleGroup` enum.
4. `WorkoutService` with workout list, `getAll()`, `getByMuscle()`.
5. `WorkoutController` with 2 GET endpoints. All pushed to GitHub (latest commit `1c21562 Adding api`).

Concepts I've learned: classes/fields/getters, enums, `List`/`ArrayList`, for-each loops, `@Service`, `@RestController` vs `@Controller`, `@GetMapping`, `@PathVariable`, dependency injection via constructor, HTTP GET/POST/PUT/DELETE, basic git (add, commit, push).

Lessons from mistakes:
- Don't name a local variable the same as a field (I shadowed `workouts` once, so the method returned an empty list).
- `@GetMapping` with no path maps to `/` and clashes with `HomeController`.
- Avoid `git pull --rebase` with merge commits: it once dropped my commit (recovered via `git reflog`).

## 7. Target final structure (goal, built section by section)

```
myweb/
├── pom.xml                      + data-jpa, postgresql, security, validation
├── Dockerfile
├── docker-compose.yml           app + PostgreSQL
├── README.md
├── PROJECT_REPORT.md
├── uploads/                     photos, videos, resume PDF (not in git)
└── src/
    ├── main/
    │   ├── java/com/devruz/myweb/
    │   │   ├── MywebApplication.java
    │   │   │
    │   │   ├── home/
    │   │   │   ├── Profile.java               photo, name, aboutMe, resumeFile
    │   │   │   ├── SocialLink.java            GitHub, LinkedIn, LeetCode, Telegram...
    │   │   │   ├── ProfileRepository.java
    │   │   │   ├── ProfileService.java
    │   │   │   └── HomeController.java        /  and  /resume (download)
    │   │   │
    │   │   ├── swe/
    │   │   │   ├── Experience.java            company, role, start, end, description
    │   │   │   ├── ExperienceRepository.java
    │   │   │   ├── SweService.java
    │   │   │   └── SweController.java         /swe (timeline)
    │   │   │
    │   │   ├── study/
    │   │   │   ├── Education.java             school, degree, years
    │   │   │   ├── Award.java                 title, date, description, image
    │   │   │   ├── Certificate.java           name, issuer, date, link
    │   │   │   ├── StudyRepository.java
    │   │   │   ├── StudyService.java
    │   │   │   └── StudyController.java       /study
    │   │   │
    │   │   ├── projects/
    │   │   │   ├── Project.java               name, description, techStack, githubUrl,
    │   │   │   │                              demoUrl (live, embedded), videoUrl, screenshots
    │   │   │   ├── ProjectRepository.java
    │   │   │   ├── ProjectService.java
    │   │   │   └── ProjectController.java     /projects, /projects/{slug} (run + watch)
    │   │   │
    │   │   ├── gallery/
    │   │   │   ├── Photo.java                 fileName, caption, date
    │   │   │   ├── PhotoRepository.java
    │   │   │   ├── PhotoService.java          save upload, make thumbnail
    │   │   │   └── GalleryController.java     /gallery
    │   │   │
    │   │   ├── cooking/
    │   │   │   ├── CookingPost.java           title, story, ingredients, steps, photos
    │   │   │   ├── CookingRepository.java
    │   │   │   ├── CookingService.java
    │   │   │   └── CookingController.java     /cooking, /cooking/{slug}
    │   │   │
    │   │   ├── gym/
    │   │   │   ├── MuscleGroup.java           enum                      (exists)
    │   │   │   ├── Workout.java               @Entity                   (exists)
    │   │   │   ├── WorkoutLog.java            date, workout, sets, reps, weight (progress)
    │   │   │   ├── BodyWeight.java            date, kg
    │   │   │   ├── WorkoutRepository.java
    │   │   │   ├── WorkoutService.java                                  (exists)
    │   │   │   ├── WorkoutApiController.java  /api/workouts...          (exists as WorkoutController)
    │   │   │   └── GymPageController.java     /gym (page + charts)
    │   │   │
    │   │   ├── blog/
    │   │   │   ├── Post.java                  title, slug, content (Markdown), date, tags
    │   │   │   ├── PostRepository.java
    │   │   │   ├── PostService.java
    │   │   │   └── BlogController.java        /blog, /blog/{slug}
    │   │   │
    │   │   ├── startups/
    │   │   │   ├── Startup.java               name, role, stage, story, website
    │   │   │   ├── Investment.java            company, date, amount (optional), notes
    │   │   │   ├── StartupRepository.java
    │   │   │   ├── StartupService.java
    │   │   │   └── StartupController.java     /startups, /startups/{slug}
    │   │   │
    │   │   ├── admin/
    │   │   │   └── AdminController.java       /admin/** forms to add/edit everything
    │   │   │
    │   │   ├── auth/
    │   │   │   └── SecurityConfig.java        only owner can open /admin
    │   │   │
    │   │   └── common/
    │   │       ├── FileStorageService.java    saves uploads (photos, videos, resume)
    │   │       ├── GlobalExceptionHandler.java
    │   │       └── NotFoundException.java
    │   │
    │   └── resources/
    │       ├── application.properties         port, database, upload folder
    │       ├── static/
    │       │   ├── css/style.css
    │       │   ├── js/gym-charts.js
    │       │   └── images/
    │       └── templates/
    │           ├── fragments/header.html      Home + menu (SWE ... Startups)
    │           ├── fragments/footer.html
    │           ├── index.html                 profile card (photo, about, links, resume)
    │           ├── swe.html
    │           ├── study.html
    │           ├── projects/list.html
    │           ├── projects/detail.html       live demo iframe + video
    │           ├── gallery.html
    │           ├── cooking/list.html
    │           ├── cooking/post.html
    │           ├── gym.html
    │           ├── blog/list.html
    │           ├── blog/post.html
    │           ├── startups/list.html
    │           ├── startups/detail.html
    │           ├── admin/...                  dashboard + one form per section
    │           ├── login.html
    │           └── error/404.html
    │
    └── test/java/com/devruz/myweb/            one service/controller test per section
```

## 8. Build order (suggested)

1. **Gym** (in progress): finish data fixes, then HTML page `/gym`.
2. **Home**: profile card from the sketch + shared header menu (all section links).
3. **Projects** (most important for employers): list + detail page with demo/video.
4. **SWE** and **Study**.
5. **Blog**, **Cooking**, **Startups** (similar "post" pages, quick once blog is done).
6. **Gallery** (file uploads).
7. Database (PostgreSQL + JPA), then admin panel + login, then deploy with Docker.

## 9. Next tasks (in order)

1. **Small data fixes in `WorkoutService`:** rename "Peck dec fly" to "Pec deck fly"; change Leg press, Leg extensions and One leg squat from `HAMSTRINGS` to `QUADRICEPS`. Check `/api/workouts/muscle/QUADRICEPS`, then push.
2. **Gym HTML page:** a `@Controller` + Thymeleaf template (`/gym`) that shows workouts in a table, grouped/filterable by muscle, instead of raw JSON.
3. Make muscle lookup friendlier (accept lowercase like `chest`, clear error for unknown values instead of 400).
4. Home page from the sketch + shared header menu, styled as Option A (black letters), with `style.css` using CSS variables for colors.
5. Light/night mode toggle: button in the header, `.night` class swaps the CSS variables, JavaScript to toggle it, `localStorage` to remember it.
