function dateDiffInDays(date1, date2) {
    const time1 = date1.getTime();
    const time2 = date2.getTime();
    const difference = time2 - time1;
    const differenceInDays = difference / (1000 * 60 * 60 * 24);
    return Math.round(differenceInDays);
}

document.addEventListener("DOMContentLoaded", function () {
    if (bookings != null) {
        console.log(bookings);
        const cards = document.getElementById("tours-card");
        let html = "";
        for (let i = 0; i < bookings.length; i++) {
            const { activities, bookingAmount, destination, maxSeats, source, tourDetailInfo, tourEndDate, tourId, tourName, tourStartDate, tourType, transportationMode } = bookings[i]["tourDetails"];
            const GenHtml = `
            <section class="flex flex-col items-center space-y-8 my-6">
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
                                <button class='text-lg font-semibold border mt-2 border-orange-800 bg-orange-600 px-4 py-1 rounded-full text-amber-950'>
                                <a href="/booking/delete/${bookings[i].bookingId}" class="bookingHref" >Delete Booking</a>
                                </button>
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

    }
    // const cards = document.getElementById("tours-card");
    // let html = "";
    // for (let i = 0; i < 1; i++) {
    //     const GenHtml = `
    //         <section class="flex flex-col items-center space-y-8 my-6">
    //                 <div
    //                     class="w-7/12 px-6 py-6  rounded-lg basis-1/2 shadow-2xl border bg-yellow-400 border-yellow-800 ">
    //                     <h3 class="text-2xl text-amber-900 pb-2">Hydrerabad to KENYA</h3>
    //                     <hr class="border-yellow-800 border-t-2">
    //                     <div class="flex flex-row-reverse relative top-3 left-0 ">
    //                         <div class="absolute">
    //                             <p class="text-4xl w-full text-amber-900 pr-5 pt-11 text-right">48000/-</p>
    //                             <p class="text-md pr-16 text-amber-800  text-right w-full ">per person</p>
    //                         </div>
    //                     </div>
    //                     <div class="">
    //                         <p class="text-4xl mt-4 mb-3 text-amber-900 ">Kenyan Adventure</p>
    //                         <div class="flex flex-row">
    //                             <div class="w-max text-amber-900 align-content mr-4 h-4">
    //                                 <img src="/images/icons8-home-24.png" alt="home" class="inline-block">
    //                                 <p class="inline-block text-md "> 21 days</p>
    //                             </div>
    //                             <div class="w-max text-amber-900 align-content mr-4 h-4">
    //                                 <img src="/images/icons8-people-24.png" alt="people" class="inline-block ">
    //                                 <p class="inline-block text-md ">45 seats</p>
    //                             </div>
    //                             <div class="w-max text-amber-900 align-content mr-4 h-4 mb-4">
    //                                 <img src="/images/FLIGHT.png" alt="travel"
    //                                     class="inline-block h-5" id="transport">
    //                                 <p class="inline-block text-md" id="trans">By FLIGHT</p>
    //                             </div>
    //                         </div>
    //                         <div class="flex flex-row flex-wrap items-center mb-1">
    //                             <label class="text-xl align-middle font-semibold mr-2">Activities :</label>
    //                             <p class="text-xl align-middle text-amber-900">wildlife safari, bird watching</p>
    //                         </div>
    //                         <div class="flex flex-row flex-wrap items-center mb-1 ">
    //                             <label class="text-xl align-middle font-semibold mr-2">Tour Type :</label>
    //                             <p class="text-xl align-middle text-amber-900">INTERNATIONAL</p>
    //                         </div>
    //                         <div class="flex flex-row flex-wrap items-center mb-1 ">
    //                             <label class="text-xl align-middle font-semibold mr-2">Tour details :</label>
    //                             <p class="text-xl align-middle text-amber-900">Embark on an unforgettable journey through the wilderness of Kenya</p>
    //                         </div>
    //                         <div class="flex flex-row flex-wrap items-center mb-1 ">
    //                             <label class="text-xl align-middle font-semibold mr-2">Start Date :</label>
    //                             <p class="text-xl align-middle text-amber-900 mr-6">2024-07-20</p>
    //                             <label class="text-xl align-middle font-semibold mr-2">End Date :</label>
    //                             <p class="text-xl align-middle text-amber-900">2024-08-10</p>
    //                             <div class=" book-button mx-14 ">
    //                             <button class='text-lg font-semibold border mt-2 border-orange-800 bg-orange-600 px-4 py-1 rounded-full text-amber-950'>
    //                             <a href="/booking/delete/16" class="bookingHref" >Delete Booking</a>
    //                             </button>
    //                             </div>
    //                         </div>
    //                     </div>
    //                 </div>

    //             </section>`;
    //     html += GenHtml;

    //     // const button = document.getElementsByClassName("bookingHref");
    //     // button.href = `/booking/createBooking/tour/${tourId}/user/${user.userId}`;

    // }
    // cards.innerHTML += html;
});