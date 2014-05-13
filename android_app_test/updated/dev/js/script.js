model = new Backbone.Model({
  	data:[
  		{
  			url : 'http://gmail.com/',
  		 	ruleset : [
  		 		{option : 'Apurba', id : 'pramati' },
  		 		{option : 'Ashfaq', id : 'ySlow'},
  		 		{option : 'Pramati', id : 'eyeLab'}
  		 	],
  		 	overallGrade : "A",
  		 	overallPerformanceScore : 80,
  		 	activities :[
  		 	{
  		 		activityName : 'Scan',
  		 		activityId : 'scan',
  		 		activityGrade : 'E',
  		 		activityDetails : [
  		 			{ 
  		 				launchTime : 70, 
  		 				activityBackStack : 0, 
  		 				noOfOverdraws:6, 
  		 				gcCocurrent : 56, 
  		 				gcAlloc : 'not available',
  		 				activityDescription : "Code snippet for how to use Font Awesome on any element and a full list of all the Font Awesome icons and their CSS content values. Updated to v 4.0."
  		 			 }
  		 		]
  		 	},
  		 	{
  		 		activityName : 'Settings',
  		 		activityGrade : 'A',
  		 		activityId : 'settings',
  		 		activityDetails : [
  		 			{ 
  		 				launchTime : 54, 
  		 				activityBackStack : 10, 
  		 				noOfOverdraws: 'not available', 
  		 				gcCocurrent : 56, 
  		 				gcAlloc : 6,
  		 				activityDescription : "Code snippet for how to use Font Awesome on any element and a full list of all the Font Awesome icons and their CSS content values. Updated to v 4.0."
  		 			 }
  		 		]
  		 	}
  		 	]
  		 },
  	]
  	
  });
  
  var View = Backbone.View.extend({
  	
  	// initialzing 
  	initialize 	: 	function(){
  					this.render();
  					},
  	
  	//targetting DOM	
  	el : '#container',			
  	url 		: 	$('#urlText'),
  	grade 		: 	$('#grade'),
  	overallPerformanceScore : $('.performScoreNumber'),
  	activities : $('#activities'),
  	
  	// rendering on targeted DOM
  	render  	: 	function(){
			  	    
			  	    // getting Data from Model.data
			  		var data = this.model.get('data');
			  			data = data[0],
			  			overallGradeValue = data.overallGrade,
			  			overallGradeValueSmall  = overallGradeValue.toLowerCase(),
			  			overallPerformanceScoreValue = data.overallPerformanceScore;
			  			
			  		
			  		// setting data to targetted DOM
			  		this.url.text(data.url);
			  	
			  		for(var i = 0, l = data.ruleset.length; i < l; i++){
			  			var ruleSetOption = data.ruleset[i].option;
			  			this.$el.find('.selectpicker').append("<option value='update' data-subtext='old subtext'>"+ruleSetOption+"</option>");
			  		}
			  	    
			  		this.grade.text(overallGradeValue);
			  		this.grade.addClass('grade-'+overallGradeValueSmall);
			  		this.overallPerformanceScore.text(overallPerformanceScoreValue);
			  		
			  		for(var i = 0, l = data.activities.length; i<l; i++){
			  			var activityGradeValue = data.activities[i].activityGrade,
			  			activityGradeValueSmall = activityGradeValue.toLowerCase();
			  			this.$el.find('#activities ul').append("<li><a class='leftTabAction' href='#"+data.activities[i].activityId+"' data-toggle='tab'><div class='gradeBlock grade-"+activityGradeValueSmall+"'>"+activityGradeValue+"</div>"+data.activities[i].activityName+"</a></li>");			
			  			$('#activities ul li:first-child').addClass('active');
			  		}
			  		
  				},
  	
  	
  	events : {
  		'click .leftTabAction' : 'activityDescription',
  	},
  		
  	activityDescription : function(event){
      	var data = this.model.get('data');
			data = data[0];
			
    },
    
    
  });
  
  var view = new View({model : model});
    	  
  
// Applying Styles on the ruleset selection  
$(".selectpicker").selectpicker();

function modifications() {
    // Create subtext
    $(".selectpicker > option:eq(0)").attr("data-subtext", "ySlow");

    // Modify subtext
    $(".selectpicker > option:eq(1)").attr("data-subtext", "Eye Log");

    // Delete subtext
    $(".selectpicker > option:eq(2)").removeAttr("Pramati");

    // Update control
    $(".selectpicker").selectpicker("refresh");
}


$('.container-wrapper-start-up').on('click', function(){
  $(this).addClass('hide-this');
  $('.container-wrapper-search-app').addClass('show-this');
  
  
})

// Change width value on page load
$(document).ready(function(){
    responsive_resize();
});
 
// Change width value on user resize, after DOM
$(window).resize(function(){
     responsive_resize();
});
 
  function responsive_resize(){
	 var current_width = $(window).width();
    //do something with the width value here!
	 if(current_width < 481)
      $('html').addClass("m320").removeClass("m768").removeClass("desktop").removeClass("m480");
 
    else if(current_width < 739)
      $('html').addClass("m768").removeClass("desktop").removeClass("m320").removeClass("tablet");
 
    else if (current_width < 970)
      $('html').addClass("tablet").removeClass("desktop").removeClass("m320").removeClass("m768");
 
    else if (current_width > 971)
      $('html').addClass("desktop").removeClass("m320").removeClass("m768").removeClass("tablet");
 
    if(current_width < 650){
      $('html').addClass("mobile-menu").removeClass("desktop-menu");
	 $('.sf-menu').removeClass("sf-js-enabled").addClass("sf-js-disabled");
	}
 
    if(current_width > 651){
      $('html').addClass("desktop-menu").removeClass("mobile-menu");
	  $('.sf-menu').removeClass("sf-js-disabled").addClass("sf-js-enabled");
	}
  }

// Change width value on user resize, after DOM
$(window).resize(function(){
     responsive_resize();
});
 
  function responsive_resize(){
	 var current_width = $(window).width();
    //do something with the width value here!
	 if(current_width < 481)
      $('html').addClass("m320").removeClass("m768").removeClass("desktop").removeClass("m480");
 
    else if(current_width < 739)
      $('html').addClass("m768").removeClass("desktop").removeClass("m320").removeClass("tablet");
 
    else if (current_width < 970)
      $('html').addClass("tablet").removeClass("desktop").removeClass("m320").removeClass("m768");
 
    else if (current_width > 971)
      $('html').addClass("desktop").removeClass("m320").removeClass("m768").removeClass("tablet");
 
    if(current_width < 650){
      $('html').addClass("mobile-menu").removeClass("desktop-menu");
	 $('.sf-menu').removeClass("sf-js-enabled").addClass("sf-js-disabled");
	}
 
    if(current_width > 651){
      $('html').addClass("desktop-menu").removeClass("mobile-menu");
	  $('.sf-menu').removeClass("sf-js-disabled").addClass("sf-js-enabled");
	}
  }
