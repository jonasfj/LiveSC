@LSC ?= {}
#### Sidebar that lists all charts in a specification
class @LSC.Sidebar
	constructor: (@parent) ->
	# Adds a chart to the sidebar
	addEntry: (index, name, switcher, remover) ->
		@entry = $("<div class='item'><span>#{name}</span></div>")
		# button to delete chart with given index
		@remover = $("<span>x</span>")
		@remover.css
			float:"right"
			opacity: .25
			width:"20px"
			"text-align":"center"
		@remover.hover(
			-> $(this).css
				opacity: 1.0
				"border-radius":"20%"
				background:"#fff",
			-> $(this).css
				"border-radius":"0"
				background:"none"
				opacity: .25)
		@remover.appendTo(@entry)
		@entry.appendTo(@parent)
		@entry.data("index", index)
		@entry.click -> 
			switcher?(index)
		@remover.click ->
			if confirm "You are about to delete a chart, proceed?"
				remover?(index)
				$(this).parent().remove()
	# updates the title of the chart in the sidebar
	updateEntry: (index, name) =>
		@parent.children().each ->
			if $(@).data("index") == index
				$(@).children("span:first").html(name)
	removeEntry: (index) =>
		@parent.children().each ->
			if $(@).data("index") == index
				$(@).remove()
	clear: =>
		@parent.children().each ->
			$(@).remove()