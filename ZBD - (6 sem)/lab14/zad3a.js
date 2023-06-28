connect("mongodb://127.0.0.1:27017");

function szukaj() {
	
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
		$addFields: {
			wynagr_netto:"$k2.wynagr_netto",
			wynagr_brutto:{$multiply: ["$k2.wynagr_netto",1.23]},
		}
	},
	{
		$project: {_id:0,wynagr_netto:1,wynagr_brutto:1}
	},
	{$group:{_id:{},avg:{$avg:"$wynagr_netto"}}}
]);

srednia = dane.next().avg;

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
			wynagr_netto:"$k2.wynagr_netto",
			wynagr_brutto:{$multiply: ["$k2.wynagr_netto",1.23]},
			wiek:{$subtract:[{$year:ISODate()},{$year:"$data_ur"}]},
			zawod:"$k3.zawod",
			miasto:"$k2.miasto"
		}
	},
	{
		$match: {wynagr_brutto:{$gt:srednia}}
	},
	{
		$project: {_id:0,zawod:1,nazwisko:1,miasto:1,wiek:1,wynagr_netto:1,wynagr_brutto:1}
	},
	{ $count: "zawod" }
]);

print(dane);

}

szukaj();