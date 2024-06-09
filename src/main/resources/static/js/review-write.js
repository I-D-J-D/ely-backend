document.addEventListener('DOMContentLoaded', () => {
    const stars = document.querySelectorAll('#star-rating li');

    stars.forEach((star, index) => {
        star.addEventListener('click', () => {
            updateStars(index + 1);
        });
    });

    function updateStars(rating) {
        stars.forEach((star, index) => {
            if (index < rating) {
                star.classList.add('selected');
            } else {
                star.classList.remove('selected');
            }
        });
    }
});