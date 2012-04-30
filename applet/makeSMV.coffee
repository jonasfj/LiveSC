fs				= require "fs"
{LSC}			= require "../src/smv.coffee"

unless process.argv[2]?
	process.exit(1)

file = process.argv[2]

# Load data
data = fs.readFileSync(file).toString()
json = JSON.parse(data)

# Save to file
smv = LSC.toSMV(json.charts)
fs.writeFileSync("TS.smv", smv)
