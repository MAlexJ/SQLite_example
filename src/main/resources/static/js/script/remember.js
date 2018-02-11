$(function () {
    if (localStorage.chkbx && localStorage.chkbx !== '') {
        $('#remember_me').attr('checked', 'checked');
        $('#inputEmail').val(localStorage.usrname);
        $('#inputPassword').val(localStorage.pass);
    } else {
        $('#remember_me').removeAttr('checked');
        $('#inputEmail').val('');
        $('#inputPassword').val('');
    }
    $('#remember_me').click(function () {
        if ($('#remember_me').is(':checked')) {
            // save username and password
            localStorage.usrname = $('#inputEmail').val();
            localStorage.pass = $('#inputPassword').val();
            localStorage.chkbx = $('#remember_me').val();
        } else {
            localStorage.usrname = '';
            localStorage.pass = '';
            localStorage.chkbx = '';
        }
    });
});