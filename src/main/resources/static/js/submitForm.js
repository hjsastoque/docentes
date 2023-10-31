function submitForm(form) {
		var input = document.getElementById("nombres").value;
        swal({
            title: "Esta seguro?",
            text: "Se editara el usuario " + input,
            icon: "success",
            buttons: true,
            
        })
        .then(function (isOkay) {
            if (isOkay) {
                form.submit();
            }
        });
        return false;
    }