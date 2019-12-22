$(document).ready(function() {

    $('#addDevice').click(function() {
        $("#regErrMsg").hide();
        $("#authErrMsg p").text("");
    });

    $('#authenticate').click(function() {
        $("#regErrMsg").hide();
        $("#authErrMsg p").text("");
    });

    $('#unpair').click(function() {
        $("#regErrMsg").hide();
        $("#authErrMsg p").text("");
    });

    // Attach a submit handler to the form
    $( "#reg_form" ).submit(function( event ) {

        // Stop form from submitting normally
        event.preventDefault();

        // Send the data using post
        var posting = $.post( $('#reg_form').attr('action'), $( "#reg_form" ).serialize() );

        // Put the results in a div
        posting.done(function( data ) {
            $( "#redirect" ).html(data);
            $( "#redirectForm" ).submit();
        })
        .fail(function( error ) {
            $("#regErrMsg p").html(error.responseText);
            $("#regErrMsg").show();
        });
    });

    $("#table tr.device_name").click(function(){
        $(this).addClass('selected').siblings().removeClass('selected');
        var value=$(this).find('td:first').html();
        $( '#authMsg' ).html( "Your choice: <strong>"+value+"</strong>");
        $("#authErrMsg p").text("");
    });

    $( "#auth_form" ).submit(function( event ) {

        // Stop form from submitting normally
        event.preventDefault();

        var id = $("#table tr.selected").data('value');

        if (id == undefined) {
            $('#authErrMsg p').text("Please select a device.")
            return;
        }

        // Send the data using post
        var posting = $.post( $('#auth_form').attr('action') , {deviceId: id} );

        // Put the results in a div
        posting.done(function( data ) {
            $( "#redirect" ).html(data);
            $( "#redirectForm" ).submit();
        })
        .fail(function( error ) {
            $("#authErrMsg p").html(error.responseText);
            $("#authErrMsg").show();
        });
    });

    $( "#unpair_form" ).submit(function( event ) {

        var id = $("#table tr.selected").data('value');

        if (id == undefined) {
            // Stop form from submitting normally
            event.preventDefault();

            $('#authErrMsg p').text("Please select a device.")
            return;
        }

        $( "#deviceId" ).val(id);
    });
});

