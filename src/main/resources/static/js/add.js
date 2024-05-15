
$(document).ready(function() {

   $('#add_btn').click(function() {
      var item = {};
      item['number'] = $('#doc_number_input').val();
      item['type'] = $('#doc_type_input').val();
      item['name'] = $('#doc_name_input').val();
      item['date'] = $('#doc_date_input').val();
      item['url'] = $('#doc_url_input').val();

      $.ajax({
         url: '/documents',
         type: 'POST',
         contentType: "application/json; charset=utf-8",
         dataType: "json",
         data: JSON.stringify(item),
         success: function(response) {
            location.href = "/"
         }
      });

   });

});