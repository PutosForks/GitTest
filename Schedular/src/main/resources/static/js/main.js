$(document).ready(function () {
    $('.table .eBtn, .nBtn').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        var text = $(this).text();

        if (text == "Edit") {

            $.get(href, function (country, status) {
                $('.myForm #id').val(country.id);
                $('.myForm #name').val(country.name);
                $('.myForm #capital').val(country.capital);
            })

        } else {
                $('.myForm #id').val('');
                $('.myForm #name').val('');
                $('.myForm #capital').val('');
        }
        $('.myForm #exampleModal').modal();
    })


    $('.table .dBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $("#deleteModal #delRef").attr("href", href);
        $('#deleteModal').modal();
    });
})