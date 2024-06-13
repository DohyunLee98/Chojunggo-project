document.querySelectorAll('.chat-item').forEach(function(chatItem) {
    chatItem.addEventListener('click', function() {
        // 모든 chat-item에서 active 클래스 제거
        document.querySelectorAll('.chat-item').forEach(function(item) {
            item.classList.remove('active');
        });
        // 클릭된 chat-item에 active 클래스 추가
        chatItem.classList.add('active');
        
        var chatIndex = chatItem.getAttribute('data-chat-id').replace('chat', '');
        
        // 모든 iframe을 숨김
        document.querySelectorAll('iframe').forEach(function(iframe) {
            iframe.classList.add('hidden');
            iframe.classList.remove('visible');
        });
        
        // 선택된 iframe만 보임
        var iframe = document.getElementById('chat' + chatIndex);
        iframe.classList.remove('hidden');
        iframe.classList.add('visible');
        
        // no-chat-selected 메시지 숨김
        document.querySelector('.no-chat-selected').style.display = 'none';
    });
});
