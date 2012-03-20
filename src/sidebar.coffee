@LSC ?= {}

class @LSC.Sidebar
	constructor: () ->
	update: (chart) =>
		if @ting?
			@ting.remove()
			@ting = null
		@table = "<table>" #<tr><td>HEJ</td></tr>
		@table += "<tr><td style='width:250px;'>" + chart.name
		@table += "</td></tr>\n"
		for instance in chart.instances
			@table += "<tr><td class='instancerow'>" + instance.name
			@table += "</td></tr>\n"
		@table += "</table>"
		@ting = $(@table)
		@ting.appendTo("#chartlist")