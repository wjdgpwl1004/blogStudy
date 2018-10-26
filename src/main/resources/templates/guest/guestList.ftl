<style rel="stylesheet">
#body {
  background-color: #91ced4;
}
#body * {
  box-sizing: border-box;
}
.board_table_title {
  background-color: #327a81;
  color: white;
  font-size: 1.5em;
  padding: 1rem;
  text-align: center;
  text-transform: uppercase;
}

.board_img {
  border-radius: 50%;
  height: 60px;
  width: 60px;
}

.table-users {
  border: 1px solid #327a81;
  border-radius: 10px;
  box-shadow: 3px 3px 0 rgba(0, 0, 0, 0.1);
  max-width: calc(100% - 2em);
  margin: 1em auto;
  overflow: hidden;
  width: 800px;
}

.board_table {
  width: 100%;
}
.board_table td, .board_table th {
  color: #2b686e;
  padding: 10px;
}
.board_table td {
  text-align: center;
  vertical-align: middle;
}
.board_table td:last-child {
  font-size: 0.95em;
  line-height: 1.4;
  text-align: left;
}
.board_table th {
  background-color: #daeff1;
  font-weight: 300;
}
.board_table tr:nth-child(2n) {
  background-color: white;
}
.board_table tr:nth-child(2n+1) {
  background-color: #edf7f8;
}

@media screen and (max-width: 700px) {
  table, tr, td {
    display: block;
  }

  td:first-child {
    position: absolute;
    top: 50%;
    -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
    width: 100px;
  }
  td:not(:first-child) {
    clear: both;
    margin-left: 100px;
    padding: 4px 20px 4px 90px;
    position: relative;
    text-align: left;
  }
  td:not(:first-child):before {
    color: #91ced4;
    content: '';
    display: block;
    left: 0;
    position: absolute;
  }
  td:nth-child(2):before {
    content: 'Name:';
  }
  td:nth-child(3):before {
    content: 'Email:';
  }
  td:nth-child(4):before {
    content: 'Phone:';
  }
  td:nth-child(5):before {
    content: 'Comments:';
  }

  tr {
    padding: 10px 0;
    position: relative;
  }
  tr:first-child {
    display: none;
  }
}
@media screen and (max-width: 500px) {
  .board_table_title {
    background-color: transparent;
    color: white;
    font-size: 2em;
    font-weight: 700;
    padding: 0;
    text-shadow: 2px 2px 0 rgba(0, 0, 0, 0.1);
  }

  img {
    border: 3px solid;
    border-color: #daeff1;
    height: 100px;
    margin: 0.5rem 0;
    width: 100px;
  }

  td:first-child {
    background-color: #c8e7ea;
    border-bottom: 1px solid #91ced4;
    border-radius: 10px 10px 0 0;
    position: relative;
    top: 0;
    -webkit-transform: translateY(0);
            transform: translateY(0);
    width: 100%;
  }
  td:not(:first-child) {
    margin: 0;
    padding: 5px 1em;
    width: 100%;
  }
  td:not(:first-child):before {
    font-size: .8em;
    padding-top: 0.3em;
    position: relative;
  }
  td:last-child {
    padding-bottom: 1rem !important;
  }

  tr {
    background-color: white !important;
    border: 1px solid #6cbec6;
    border-radius: 10px;
    box-shadow: 2px 2px 0 rgba(0, 0, 0, 0.1);
    margin: 0.5rem 0;
    padding: 0;
  }

  .table-users {
    border: none;
    box-shadow: none;
    overflow: visible;
  }
}
p, h1, form, button{border:0; margin:0; padding:0;}
.spacer{height:1px;}

.myform{
	margin:10px;
	width:400px;
	padding:14px;
}

#stylized{
	border:solid 2px #b7ddf2;
	background:#ebf4fb;
}
#stylized h1 {
	font-size:16px;
	font-weight:bold;
	margin-bottom:8px;
	font-family:nanumgothic,dotum;

}
#stylized p{
	font-size:11px;
	color:#666666;
	margin-bottom:20px;
	border-bottom:solid 1px #b7ddf2;
	padding-bottom:10px;
	font-family:dotum;
}
#stylized label{
	display:block;
	font-weight:bold;
	text-align:right;
	width:140px;
	float:left;
	font-family:tahoma;
}
#stylized .small{
	color:#666666;
	display:block;
	font-size:11px;
	font-weight:normal;
	text-align:right;
	width:140px;
	font-family:dotum;
	letter-spacing:-1px;
}
#stylized input{
float:left;
font-size:12px;
padding:4px 2px;
border:solid 1px #aacfe4;
width:200px;
margin:2px 0 20px 10px;
}

</style>


<div id="body">
                                                <#-- spring의 Requestcontext를 사용가능 --> 
    <form name="frm" id="frm" method="get" action="${springMacroRequestContext.requestUri}">

    <div class="table-users">
    <div class="board_table_title">GUEST</div>

        <table class="board_table">
            <tr>
                <th>Picture</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th width="230">Comments</th>
            </tr>

            <tr>
                <td><img class="board_img" src="http://lorempixel.com/100/100/people/1" alt="" /></td>
                <td>Jane Doe</td>
                <td>jane.doe@foo.com</td>
                <td>01 800 2000</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. </td>
            </tr>
        </table>
     </div>   
        <#--<input type="hidden" name="_method" value="delete"/>-->
       <div class="btnArea" style="text-align:center;">
             <div id="stylized" class="myform" style="margin:0 auto;">
                <form id="form" name="form" method="post">
                <h1>글쓰기 폼</h1>
                <p>기본적인 입력폼입니다.</p>

                <label>Name
                <span class="small">이름 입력</span>
                </label>
                <input type="text" name="name" id="name" />

                <label>Email
                <span class="small">이메일주소</span>
                </label>
                <input type="text" name="email" id="email" />

                <label>Password
                <span class="small">패스워드 6자 이상</span>
                </label>
                <input type="text" name="password" id="password" />
                
                <button type"button" class="button" onclick="fn_submit(document.frm); return false;">방명록 작성</button>
                <div class="spacer"></div>

                </form>
            </div>

        </div>
    </form>

</div>