<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TourBud</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="styele/styleIndex.css">
</head>
<body>
    <header class="text-gray-600 body-font bg-blue-100">
        <div class="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
          <a class="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0" href="/">
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-10 h-10 text-white p-2 bg-indigo-500 rounded-full" viewBox="0 0 24 24">
              <path d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5"></path>
            </svg>
            <span class="ml-3 text-xl">TourBud</span>
          </a>
          <nav class="md:ml-auto md:mr-auto flex flex-wrap items-center text-base justify-center">
            <a href="/discover" class="mr-5 hover:text-gray-900">Discover</a>
            <a href="/trips" class="mr-5 hover:text-gray-900">Trips</a>
            <a href="/review" class="mr-5 hover:text-gray-900">Review</a>
            <a  class="mr-5 hover:text-gray-900">More</a>
          </nav>
          <button class="px-4 py-1 text-sm text-blue-600 font-semibold rounded-full border border-blue-200 hover:text-white hover:bg-blue-600 hover:border-transparent focus:outline-none focus:ring-2 focus:ring-blue-600 focus:ring-offset-2 mr-5"><a href="/login">Login</a></button>
        <button class="px-4 py-1 text-sm text-blue-600 font-semibold rounded-full border border-blue-200 hover:text-white hover:bg-blue-600 hover:border-transparent focus:outline-none focus:ring-2 focus:ring-blue-600 focus:ring-offset-2"><a href="/signup">Sign Up</a></button>
        </div>
      </header>
      <div class="searchBar ">
        <input type="text" name="place" placeholder="Enter Place to Visit" class="searchCity">
      </div>
</body>
</html>