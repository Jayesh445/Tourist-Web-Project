function dateDiffInDays(date1, date2) {
    const time1 = date1.getTime();
    const time2 = date2.getTime();
    const difference = time2 - time1;
    const differenceInDays = difference / (1000 * 60 * 60 * 24);
    return Math.round(differenceInDays);
}

document.addEventListener("DOMContentLoaded", function () {
    if (tours != null) {
        console.log(tours);
        const cards = document.getElementById("tours-card");
        let html = "";
        for (const tour of tours) {
            const { activities, bookingAmount, destination, maxSeats, source, tourDetailInfo, tourEndDate, tourId, tourName, tourStartDate, tourType, transportationMode } = tour;
            const GenHtml = `
            <section class="flex flex-col items-center space-y-8 ">
                    <div
                        class="w-7/12 px-6 py-6  rounded-lg basis-1/2 shadow-2xl border bg-yellow-400 border-yellow-800 ">
                        <h3 class="text-2xl text-amber-900 pb-2">${source} to ${destination}</h3>
                        <hr class="border-yellow-800 border-t-2">
                        <div class="flex flex-row-reverse relative top-3 left-0 ">
                            <div class="absolute">
                                <p class="text-4xl w-full text-amber-900 pr-5 pt-11 text-right">${bookingAmount}/-</p>
                                <p class="text-md pr-16 text-amber-800  text-right w-full ">per person</p>
                            </div>
                        </div>
                        <div class="">
                            <p class="text-4xl mt-4 mb-3 text-amber-900 ">${tourName}</p>
                            <div class="flex flex-row">
                                <div class="w-max text-amber-900 align-content mr-4 h-4">
                                    <img src="/images/icons8-home-24.png" alt="home" class="inline-block">
                                    <p class="inline-block text-md ">${dateDiffInDays(new Date(tourStartDate), new Date(tourEndDate))} days</p>
                                </div>
                                <div class="w-max text-amber-900 align-content mr-4 h-4">
                                    <img src="/images/icons8-people-24.png" alt="people" class="inline-block ">
                                    <p class="inline-block text-md ">${maxSeats} seats</p>
                                </div>
                                <div class="w-max text-amber-900 align-content mr-4 h-4 mb-4">
                                    <img src="/images/FLIGHT.png" alt="travel"
                                        class="inline-block h-5" id="transport">
                                    <p class="inline-block text-md" id="trans">By ${transportationMode}</p>
                                </div>
                            </div>
                            <div class="flex flex-row flex-wrap items-center mb-1">
                                <label class="text-xl align-middle font-semibold mr-2">Activities :</label>
                                <p class="text-xl align-middle text-amber-900">${activities}</p>
                            </div>
                            <div class="flex flex-row flex-wrap items-center mb-1 ">
                                <label class="text-xl align-middle font-semibold mr-2">Tour Type :</label>
                                <p class="text-xl align-middle text-amber-900">${tourType}</p>
                            </div>
                            <div class="flex flex-row flex-wrap items-center mb-1 ">
                                <label class="text-xl align-middle font-semibold mr-2">Tour details :</label>
                                <p class="text-xl align-middle text-amber-900">${tourDetailInfo}</p>
                            </div>
                            <div class="flex flex-row flex-wrap items-center mb-1 ">
                                <label class="text-xl align-middle font-semibold mr-2">Start Date :</label>
                                <p class="text-xl align-middle text-amber-900 mr-6">${tourStartDate}</p>
                                <label class="text-xl align-middle font-semibold mr-2">End Date :</label>
                                <p class="text-xl align-middle text-amber-900">${tourEndDate}</p>
                                <div class=" book-button mx-14 ">
                        
                                </div>
                            </div>
                        </div>
                    </div>

                </section>`;
            html += GenHtml;

            // const button = document.getElementsByClassName("bookingHref");
            // button.href = `/booking/createBooking/tour/${tourId}/user/${user.userId}`;

        }
        cards.innerHTML = html;
        // if (user != null) {
        //     const bookButton = document.getElementsByClassName("book-button");
        //     bookButton.innerHTML = `<button class='text-lg font-semibold border border-orange-800 bg-orange-600 px-4 py-1 rounded-full text-amber-950'>
        //     <a href="/booking" class="bookingHref">Book Seat</a>
        //     </button>`;
        // }
        if (user != null) {
            const bookButton = document.getElementsByClassName("book-button");
            for (const button of bookButton) {
                button.innerHTML = `<button class='text-lg font-semibold border mt-2 border-orange-800 bg-orange-600 px-4 py-1 rounded-full text-amber-950'>
                <a href="/tourist/addTourist" class="bookingHref" method="post">Book Seat</a>
                </button>`;
            }
            // for (const tour of tours) {
            //     const button= document.querySelector(".bookingHref");
            //     button.href= `/booking/createBooking/tour/${tour.tourId}/user/${user.userId}`;
            // }
        }
    }

    //  console.log(bookButton.innerHTML);
    // const button = document.getElementsByClassName("bookingHref");
    // button.href = `/booking/createBooking/tour/${user}/user/${user.userId}`;
    // console.log( button.href);

});