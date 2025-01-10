- 게시판(Board)
id
name

생성(/boards)
조회(/boards)
수정(/boards/{boardId})
삭제(/boards/{boardId})

- 게시글(Post)
id
title
content
author
board
comments

생성(/posts)
목록 조회(/posts)
response: id, title, author, commentNumber

상세 조회(/posts/{postId})
response: id, title, content, author, comments

수정(/posts/{postId})
삭제(/posts/{postId})

- 댓글(Comment)
id
content
author
post

생성(/posts/{postId}/comments)
수정(/posts/{postId}/comments/{commentId})
삭제(/posts/{postId}/comments/{commentId})