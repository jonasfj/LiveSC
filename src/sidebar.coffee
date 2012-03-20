@LSC ?= {}

class @LSC.Sidebar
	constructor: (@parent) ->
	addEntry: (index, name, cb) ->
		@entry = $("<div class='item'>#{name}</div>")
		@entry.appendTo(@parent)
		@entry.data("index", index)
		@entry.click -> cb?(index)
	updateEntry: (index, name) ->
		@parent.children().each (entry) ->
			if entry.data("index") == index
				entry.html(name)
	removeEntry: (index) ->
		@parent.children().each (entry) ->
			if entry.data("index") == index
				entry.remove()