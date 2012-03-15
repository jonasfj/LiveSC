fs				= require "fs"
{print}			= require "util"
{spawn, exec}	= require "child_process"
{platform}		= require "process"

coffee = "coffee"
coffee = "coffee.cmd"		if platform is "win32"

build = (watch = false) ->
	options = ["-c", "-o", "bin", "src"]
	options.unshift "-w" if watch
	coffee = spawn coffee, options
	coffee.stdout.on "data", (data) -> print data.toString()
	coffee.stderr.on "data", (data) -> print data.toString()
	coffee.on "exit", (status) ->
		if status is 0
			print "Compilation completed.\n"
		else
			print "Compilation failed!\n"

task "build", "Compile CoffeeScript files to Javascript", ->
	build()

task "watch", "Rebuild when files are changed", ->
	build(true)

task "docs", "Generate source code documentation", ->
	fs.readdir "src", (error, contents) ->
		files = ("src/#{file}" for file in contents when /\.coffee$/.test(file))
		docco = spawn "docco", files
		docco.stdout.on "data", (data) -> print data.toString()
		docco.stderr.on "data", (data) -> print data.toString()
		docco.on "exit", (status) ->
			if status is 0
				print "Documentation generated.\n"
			else
				print "docco failed!\n"

task "clean", "Cleanup generated files", ->
	exec "rm -rf bin/ docs/", (status, stdout, stderr) ->

task "debug", "Open on chromium with access to local files", ->
	exec "chromium --allow-file-access-from-files index.htm"
