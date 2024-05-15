
$(document).ready(function() {

    $('#search_btn').click(function() {
      var item = {}
      item['number'] = $('#doc_number_input').val();
      item['type'] = $('#doc_type_input').val();
      item['name'] = $('#doc_name_input').val();
      item['fromDate'] = $('#doc_startdate_input').val();
      item['toDate'] = $('#doc_enddate_input').val();

      var href = '/?';
      for(var key in item) {
          if(item[key]) {
              href += key + '=' + item[key] + '&';
          }
      }
      location.href = href;

    });

});