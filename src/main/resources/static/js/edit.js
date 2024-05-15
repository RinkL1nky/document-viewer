
$(document).ready(function() {

   $('#save_btn').click(function() {
      var item = {};
      item['id'] = parseInt($('#doc_id').text());
      item['number'] = $('#doc_number').val();
      item['type'] = $('#doc_type').val();
      item['name'] = $('#doc_name').val();
      item['date'] = $('#doc_date').val();
      item['url'] = $('#doc_url').val();

      $.ajax({
         url: '/documents/document/',
         type: 'PUT',
         contentType: "application/json; charset=utf-8",
         dataType: "json",
         data: JSON.stringify(item),
         success: function(response) {
            location.href = "/"
         }
      });

   });

});