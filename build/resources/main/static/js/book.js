
document.getElementById('timeSlotSelect').addEventListener('change', function () {
    const timeSelect = document.getElementById('timeSelect');
    timeSelect.innerHTML = '';

    let times = [];
    if (this.value === '9 AM - 1 PM') {
        times = [
            '9:00 - 9:30', '9:30 - 10:00', '10:00 - 10:30', '10:30 - 11:00',
            '11:00 - 11:30', '11:30 - 12:00', '12:00 - 12:30', '12:30 - 1:00'
        ];
    } else if (this.value === '4 PM - 8 PM') {
        times = [
            '4:00 - 4:30', '4:30 - 5:00', '5:00 - 5:30', '5:30 - 6:00',
            '6:00 - 6:30', '6:30 - 7:00', '7:00 - 7:30', '7:30 - 8:00'
        ];
    }

    times.forEach(time => {
        const option = document.createElement('option');
        option.value = time;
        option.textContent = time;
        timeSelect.appendChild(option);
    });
});


// Carousel logic
document.addEventListener('DOMContentLoaded', function () {
    const track = document.querySelector('.carousel-track');
    const prevBtn = document.querySelector('.carousel-btn.prev');
    const nextBtn = document.querySelector('.carousel-btn.next');
    const cardWidth = 320; // adjust based on actual width + margin

    let currentPosition = 0;

    function moveCarousel(direction) {
        const maxScroll = track.scrollWidth - track.clientWidth;
        currentPosition += direction * cardWidth;
        currentPosition = Math.max(0, Math.min(currentPosition, maxScroll));
        track.style.transform = `translateX(-${currentPosition}px)`;
    }

    if (track && prevBtn && nextBtn) {
        nextBtn.addEventListener('click', () => moveCarousel(1));
        prevBtn.addEventListener('click', () => moveCarousel(-1));

        // Auto-play every 3 seconds
        setInterval(() => moveCarousel(1), 3000);
    }
});