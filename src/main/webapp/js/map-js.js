const url = 'https://open-weather13.p.rapidapi.com/city/landon';
const options = {
	method: 'GET',
	headers: {
		'X-RapidAPI-Key': '78f45f632bmsh69d47ff8d50a2bbp18f00ajsnb84621afacdd',
		'X-RapidAPI-Host': 'open-weather13.p.rapidapi.com'
	}
};

try {
	const response = await fetch(url, options);
	const result = await response.text();
	console.log(result);
    jspvar();
} catch (error) {
	console.error(error);
}
$.getJSON("/map", function(city) {
    console.log("User name: " + city);
});