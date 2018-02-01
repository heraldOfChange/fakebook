<script>
    var news_feed =".news_feed";
    var auto_refresh = setInterval(
        function()
        {
            $.post("breakdown/home/newsFeed.jsp", function(data){
                $(news_feed).empty().html(data);
                console.log(data);
            });
        }, 5000);
</script>

<div id="content">
    <div class="content">
        <!-- OPTIONS -->
        <aside class="options">
            <form action="" method="post"><table>
                <tr><td><img id="profilePic" src="images/profilePicture.jpg"/></td></tr>
                <tr><td><a>${lBean.lastname}, ${lBean.firstname}</a></td></tr>
                <tr><td><input type="hidden" name="user_id" value="${lBean.id}"/></td></tr>
                <tr><td><input type="file" name="profilePic"/></td></tr>
                <tr><td><input class="button" type="submit" value="Edit profile picture" disabled /></td></tr>
            </table></form>
            
            <!-- FAVOURITES -->
            <ul>
                <li><h1>FAVOURITES</h1></li>
                <li><ul>
                        <li><a><img src="" />News Feed</a></li>
                        <li><a><img src="" />Messages</a></li>
                        <li><a><img src="" />Events</a></li>
                        <li><a><img src="" />Photos</a></li>
                        <li><a><img src="" />Find Friends</a></li>
                    </ul>
            </ul>

            <!-- GROUPS -->
            <ul>
                <li><h1>GROUPS</h1></li>
                <li><ul>
                        <li><a>sample_group</a></li>
                    </ul></li>
            </ul>

            <!-- APPS -->
            <ul>
                <li><h1>APPS</h1></li>
                <li><ul>
                        <li><a>sample_app</a></li>
                    </ul></li>
            </ul>

            <!-- FRIENDS -->
            <ul>
                <li><h1>FRIENDS</h1></li>
                <li><ul>
                        <li><a>sample_friend</a></li>
                    </ul></li>
            </ul>

            <!-- PAGES -->
            <ul>
                <li><h1>PAGES</h1></li>
                <li><ul>
                        <li><a>sample_page</a></li>
                    </ul></li>
            </ul>
        </aside>

        <!-- NEWS FEED -->
        <article class="posts">

            <!-- ONE POST -->
            <div class="post">
                <form action="postServlet" method="post">
                    <input name="current_acc" type="hidden" value="${lBean.id}"/>
                    <input name="lname" type="hidden" value="${lBean.firstname}"/>
                    <input name="fname" type="hidden" value="${lBean.lastname}"/>
                    <textarea name="post" rows="3" placeholder="Write something . . ."></textarea>
                    <input class="btn" name="postBtn" type="submit" value="Post"/>
                </form>
            </div>

            <!-- NEWS FEED -->
            <div class="news_feed">
                <%@include file="/breakdown/home/newsFeed.jsp" %>
            </div>
        </article>

        <!-- OTHERS -->
        <aside class="updates">

            <!-- FRIEND REQUESTS -->
            <ul>
                <li><h1>Friend Requests</h1><a>See All</a></li>
                <li>
                    <ul>
                        <li><img src="" /></li>
                        <li><a>Friends Account</a></li>
                        <li><a>Confirm Friend</a></li>
                    </ul>
                </li>
            </ul>

            <!-- GAMES YOU MAY LIKE -->
            <ul>
                <li><h1>Games You May Like</h1><a>See All</a></li>

                <li>
                    <ul>
                        <li><img src="" /></li>
                        <li><a>Friends Account</a></li>
                        <li><a>Confirm Friend</a></li>
                    </ul>
                </li>
            </ul>

            <!-- SPONSORED -->
            <ul>
                <li><h1>Sponsored</h1><a>See All</a></li>

                <li>
                    <ul>
                        <li><img src="" /></li>
                        <li><a>Friends Account</a></li>
                        <li><a>Confirm Friend</a></li>
                    </ul>
                </li>
            </ul>
        </aside>
    </div>
</div>