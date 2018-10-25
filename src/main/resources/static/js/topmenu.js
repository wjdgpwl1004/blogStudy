function topmenu(el, menuCode, duration){
	var self = this;
	self.el = $(el); // 탑메뉴 최상위 엘리먼트
	self.is_open = false;
	self.is_start = false;

	// menu code parsing 
	self.depth1 = Number(menuCode.substr(0,2))-1;
	self.depth2 = Number(menuCode.substr(2,2))-1;
	self.depth3 = Number(menuCode.substr(4,2))-1;

	// duration
	self.duration = duration ? duration : 300;

	// depth1 
	self.depth1_li = self.el.find('#gnb_device').children('li');

	// depth2
	self.depth2_li = self.el.find('.depth2_ul').children('li');

	// depth3
	self.depth3_li = self.el.find('.depth3_ul').children('li');


	// current 
	self.current_dpeth1_li = self.el.find('#gnb_device').children('li').eq(self.depth1);
	self.current_dpeth2_li = self.current_dpeth1_li.find('.depth2_ul').children('li').eq(self.depth2);
	self.current_dpeth3_li = self.current_dpeth2_li.find('.depth3_ul').children('li').eq(self.depth3);

 
	// set current
	self.current = function() {
		self.current_dpeth1_li.addClass('current');
		self.current_dpeth2_li.addClass('current');
		self.current_dpeth3_li.addClass('current');
	}


	// set icon
	self.depth1_li.each(function() {
		var jqThis = $(this);
		if ( jqThis.find('.depth2_ul').length > 0 ) {
			jqThis.addClass('arcodian');
			jqThis.children('a').on('click', function(e){
				var jqThis_2 = $(this);
				e.preventDefault();
				self.depth1_li.removeClass('active');
				jqThis_2.parent().addClass('active');
				self.depth1_li.find('.summry').stop().slideUp(self.duration);
				jqThis.find('.summry').stop().delay(self.duration).slideDown(self.duration);
			});
		}
	});

	self.depth2_li.each(function() {
		var jqThis = $(this);
		if ( jqThis.find('.depth3_ul').length > 0 ) {
			jqThis.addClass('arcodian');
			jqThis.children('a').on('click', function(e){
				var jqThis_2 = $(this);
				e.preventDefault();
				self.depth2_li.removeClass('active');
				jqThis_2.parent().addClass('active');
				self.depth2_li.find('.depth3_ul').stop().slideUp(self.duration);
				jqThis.find('.depth3_ul').stop().delay(self.duration).slideDown(self.duration);
			});
		}
	});

	// menu open
	self.open = function() {
		self.el.css({
			zIndex: ''
		}).animate({
			right:'0px'
		},self.duration);

		self.bg_el.stop().fadeIn();
	}
	

	// menu close
	self.close = function() {
		self.el.animate({
			right:'-300px'
		},( self.is_start ? self.duration : 0), function(){
			self.el.css({
				zIndex : -1
			})
		}); // 처음 로딩때는 duration을 0으로

		self.bg_el.stop().fadeOut();
	}
	

	// event
	$('#mobile_menu_btn').on('click', function(){
		self.open();
	});
	$('#mobile_menu_close').on('click', function(){
		self.close();
	});


	// menu bg
	var bg = '<div id="mobile_menu_bg"></div>';
	self.bg_el = self.el.before(bg).prev();
	self.bg_el.css({display:'none'});

	self.bg_el.on('click', function(){
		self.close();
	});


	// start
	// self.current();	
	self.close();
	self.is_start = true;

}





