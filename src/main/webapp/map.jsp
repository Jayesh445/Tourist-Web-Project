<%@ page isELIgnored="false" %>
<c:set var="city" value=${city} />
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Maps</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="styles/styleMap.css">
    <script type="module" src="js/map-js.js"></script>
  </head>

  <body>
    <section class="text-gray-600 body-font relative">
      <div class="container px-5 py-24 mx-auto flex sm:flex-nowrap flex-wrap">
        <div
          class="lg:w-2/3 md:w-1/2 bg-gray-300 rounded-lg aspect-video overflow-hidden sm:mr-10 p-10 flex items-end justify-start relative">
          <iframe width="100%" height="100%" class="absolute inset-0" frameborder="0" title="map" marginheight="0"
            marginwidth="0" scrolling="no"
            src="https://maps.google.com/maps?width=100%&height=600&hl=en&q=${city}&ie=UTF8&t=&z=12&iwloc=B&output=embed"></iframe>
            <div class="bg-white absolute flex flex-wrap py-3 right-3 top-3 rounded shadow-md">
              
              <div class="lg:w-1/4 px-6 mt-4 lg:mt-0 weather-js text-sm">
                
             </div>
           </div>
        </div>
        

        <div class="lg:w-1/3 md:w-1/2 bg-white flex flex-col md:ml-auto w-full md:py-8 mt-8 md:mt-0">
          <div class="relative mb-4">
            <form action="/map" method="post">
              <input type="text" id ="city-input" name="place" placeholder="Enter Place to Search on Map" value="${city}">
              <button type="submit">Search</button>
            </form>
          </div>
          <div class="relative mb-4">
          <select name="option">
            <option value="hotel">Hotel</option>
            <option value="restaurant">Restaurant</option>
            <option value="touristPlaces">Tourist Places</option>
            <option value="nearbyAttration">Nearby Attration</option>
          </select>
          </div>
          <div class="relative mb-4">
            <div class="content"></div>
          </div>
        </div>
      </div>
    </section>
  </body>

</html>