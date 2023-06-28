connect("mongodb://127.0.0.1:27017");

function szukaj(miasto_f) {

var dane = db.kol1.aggregate([
{
	$lookup: {
		from: "kol2",
		localField: "nazwisko",
		foreignField: "nazwisko",
		as: "k2"
	}
},
	{
		$unwind: "$k2"
	},
{
	$lookup: {
		from: "kol3",
		localField: "nazwisko",
		foreignField: "nazwisko",
		as: "k3"
	}
},
	{
		$unwind: "$k3"
	},
	{
		$addFields: {
			wynagr_brutto:{$multiply: ["$k2.wynagr_netto",1.23]},
			wiek:{$subtract:[{$year:ISODate()},{$year:"$data_ur"}]},
			zawod:"$k3.zawod",
			miasto:"$k2.miasto"
		}
	},
	{
		$match: {miasto:miasto_f,zawod:"elektronik"}
	},
	{
		$project: {_id:0,zawod:1,nazwisko:1,miasto:1,wiek:1,wynagr_brutto:1}
	}
]);

while (dane.hasNext()){print(dane.next());}

dane = db.kol1.aggregate([
{
	$lookup: {
		from: "kol2",
		localField: "nazwisko",
		foreignField: "nazwisko",
		as: "k2"
	}
},
	{
		$unwind: "$k2"
	},
{
	$lookup: {
		from: "kol3",
		localField: "nazwisko",
		foreignField: "nazwisko",
		as: "k3"
	}
},
	{
		$unwind: "$k3"
	},
	{
		$addFields: {
			wynagr_brutto:{$multiply: ["$k2.wynagr_netto",1.23]},
			wiek:{$subtract:[{$year:ISODate()},{$year:"$data_ur"}]},
			zawod:"$k3.zawod",
			miasto:"$k2.miasto"
		}
	},
	{
		$match: {miasto:miasto_f,zawod:"elektronik"}
	},
	{
		$project: {_id:0,zawod:1,nazwisko:1,miasto:1,wiek:1,wynagr_brutto:1}
	},
	{ $count: "zawod" }
]);

print(dane);

}

szukaj("Gdańsk");