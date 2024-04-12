const  APIkey = "cf29a903ece68998b8e524f61dd675eb" ;
const city=document.getElementById("city-input").value;
const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${APIkey}`;
const weatherDom=(result) => {
    const weather = document.querySelector('.weather-js');
    console.log(result.main.temp);
	weather.innerHTML=` <p class='text-sm text-blue-800 px-1 py-1'>Temperature=${Number.parseInt(result['main']['temp'])-273}<sup>o</sup>C</p>`;
	const weatherIcon = document.getElementById("weather-icon");
	
	// const val = result.weather[0].main;
    // console.log("hello");
	// console.log(val);
}


try {
    const response = await fetch(url, {method:"GET"});
    const result = await response.text();
    console.log(typeof result);
    console.log(JSON.parse(result));
    weatherDom(JSON.parse(result));
} catch (error) {
    console.error(error);
}
