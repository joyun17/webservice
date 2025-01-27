var main = {
    init : function() {
        var _this = this;
        $('#btn-save').on('click', function (){
            console.log(22222222222222222)
            if(_this.isValid()){
                _this.save();
            }
        });
        $('#btn-update').on('click', function(){
            _this.update();
        });
        $('#btn-delete').on('click', function(){
            _this.delete();
        })

    },
    isValid : function(){
        const title = $('#title').val().trim();
        const content = $('#content').val().trim();
        console.log(111111111);
        if(title.length <10){

            alert("제목은 10자 이상 작성해 주세요");
            return false;
        }
        if(content.length<50){
            alert("내용은 20자 이상 작성해 주세요");
            return false;
        }
        return true;

    },
    save : function (){




        var data = {
            title : $('#title').val(),
            author: $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType : 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (){
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (err){
            alert(JSON.stringify(err));
        });
    },
    update : function (){
        var data = {
            title : $('#title').val(),
            content : $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType : 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (){
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (err){
            alert(JSON.stringify(err));
        });
    },
    delete : function(){
        var id = $('#id').val();
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType : 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function (){
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (err){
            alert(JSON.stringify(err));
        });
    }

};

main.init();
function registerValid(){

}