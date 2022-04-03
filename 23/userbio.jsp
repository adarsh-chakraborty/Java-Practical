<jsp:useBean id="currentUser" class="p1.User" scope="application">
</jsp:useBean>
<p>
  <span class="bio light">BIO:</span>
  <i class="light"><%= currentUser.getBIO() %></i>
</p>
