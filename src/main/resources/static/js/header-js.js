// const user = document.getElementById("userObject").value;
// console.log(user);
document.addEventListener("DOMContentLoaded", function () {
  if (user != undefined) {
    const button = document.getElementById("button-group");
    button.innerHTML = ` <p class="text-md text-white my-1 mx-4 m-0">Hello ${user.fname}</p>
    <button
    class="py-1 px-4 text-sm text-red-50 font-semibold border-1.5 rounded-full border border-red-50 hover:text-red-500 bg-red-500 hover:bg-red-50 hover:border-red-500 focus:outline-none focus:ring-2 focus:ring-red-50 focus:ring-offset-2">
    <a href="/logout">Logout</a>
    </button>`;
    const tourist = document.getElementById("tourist");
    tourist.innerText = "Add tourist";
    const booking = document.getElementById("booking");
    booking.href = `/booking/getAllbyuserId/${user.userId}`;
    booking.innerText = "Booking";
  }
});
