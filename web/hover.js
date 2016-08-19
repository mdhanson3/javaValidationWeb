$(document).ready(function(){
	

	$('[data-toggle="tooltip"]').tooltip();

	// Change the color by changing the btn class and change the 'aria-pressed' attribute
	$(".toggleButton").click( function() {
		toggleHighlights(this);
	})

	function toggleHighlights(test) {
		var $this = $(test);
		if($this.attr("aria-pressed") == "true") {
			$this.attr("aria-pressed", "false");
			$this.addClass("btn-secondary");
			$this.removeClass("btn-warning");
			removeDataToggle($this.attr("errorType"));
			removeHighlights($this.attr("errorType"));
			document.activeElement.blur();
		} else {
			$this.attr("aria-pressed", "true");
			$this.removeClass("btn-secondary");
			$this.addClass("btn-warning");
			addDataToggle($this.attr("errorType"));
			addHighlights($this.attr("errorType"));
			$this.blur();
		}
	}

	function removeHighlights(error) {
		$("." + error).removeClass("highlighted");
	}

	function addHighlights(error) {
		$("." + error).addClass("highlighted");
	}

	function removeDataToggle(error) {
		$("." + error).removeAttr("data-toggle");
	}

	function addDataToggle(error) {
		$("." + error).attr("data-toggle", "tooltip");
	}


})