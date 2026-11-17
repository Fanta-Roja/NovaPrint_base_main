// Navbar transparente sobre el hero y blanco al bajar (siempre blanco en páginas internas).
(function () {
    const nav = document.getElementById('mainNav');
    if (!nav) return;
    const fijo = document.body.classList.contains('pagina-interna');

    function actualizar() {
        nav.classList.toggle('scrolled', fijo || window.scrollY > 50);
    }
    window.addEventListener('scroll', actualizar, { passive: true });
    actualizar();

    // Oculta el mensaje de éxito del contacto tras unos segundos.
    const ok = document.getElementById('mensajeExito');
    if (ok) setTimeout(() => { ok.style.display = 'none'; }, 6000);
})();
