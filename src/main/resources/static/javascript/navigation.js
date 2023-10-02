document.addEventListener("DOMContentLoaded", function() {
    const menuToggle = document.createElement('div');
    menuToggle.classList.add('menu-toggle');
    menuToggle.textContent = '☰ Menu';

    const nav = document.querySelector('nav');
    nav.insertBefore(menuToggle, nav.firstChild);

    menuToggle.addEventListener('click', function() {
        const ul = document.querySelector('nav ul');
        ul.classList.toggle('active');
    });
    const footerToggle = document.createElement('div');
    footerToggle.classList.add('footer-toggle');
    footerToggle.textContent = '⬇ Show Footer Links';

    const footer = document.querySelector('footer');
    footer.insertBefore(footerToggle, footer.firstChild);

    footerToggle.addEventListener('click', function() {
        const ul = document.querySelector('footer ul');
        ul.classList.toggle('active');
        footerToggle.textContent = ul.classList.contains('active') ? '⬆ Hide Footer Links' : '⬇ Show Footer Links';
    });
});
