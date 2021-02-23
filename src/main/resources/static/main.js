$('document').ready(function() {
    $('#primaryButton').on('click',function(event){
        event.preventDefault();

        var href= $(this).attr('href');

        $.get(href, function(todo, status){
            $('#editId').val(todo.id);
            $('#editTitle').val(todo.title);
            $('#editDone').val(todo.done);
        });
        $('#editModal').modal();
            });


});