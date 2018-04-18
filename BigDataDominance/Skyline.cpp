
Skip to content
This repository

    Pull requests
    Issues
    Marketplace
    Explore

    @poudelpavan

1
0

    0

BDAGroup/Maximal-Dominance
Code
Issues 0
Pull requests 0
Projects 0
Wiki
Insights
Settings
Maximal-Dominance/SkylineNew.cpp
f625e2b 4 minutes ago
@ttalaeik ttalaeik Add files via upload
125 lines (96 sloc) 2.81 KB
// ConsoleApplication46.cpp : Defines the entry point for the console application.
//

#include <iostream>
#include<cmath>

using namespace std;

int K=10;

struct Skyline
{
	int distance, lat, lng, score, price;
	bool check;

};
Skyline Restaurant[10], temp;

class TopDominating {

public:
	struct Skyline
	{
		int distance, lat, lng, score, price;
		bool check;

	};

	TopDominating(int, int, int);
	void Sort_Restaurant();
	void Get_Skyline_Points();

	int K;

private:
	Skyline Restaurant[10], temp;      // K is the number of restaurants after query

};

TopDominating::TopDominating(int items, int MyLat, int MyLng)
{
	K = items;

	for (int i = 0; i < K; i++)
	{
		Restaurant[i].distance = sqrt(pow(Restaurant[i].lat - MyLat, 2) + pow(Restaurant[i].lng - MyLng, 2));
		Restaurant[i].check = true;

	}

}

void TopDominating::Sort_Restaurant( )
{
	for (int i = 0; i < K - 1; i++)
	{
		for (int j = i + 1; j < K; j++)
		{
			if (Restaurant[i].distance > Restaurant[j].distance)
			{
				temp.distance = Restaurant[i].distance;
				temp.lat = Restaurant[i].lat;
				temp.lng = Restaurant[i].lng;
				temp.score = Restaurant[i].score;
				temp.price = Restaurant[i].price;
				Restaurant[i] = Restaurant[j];
				Restaurant[j].distance = temp.distance;
				Restaurant[j].lat = temp.lat;
				Restaurant[j].lng = temp.lng;
				Restaurant[j].score = temp.score;
				Restaurant[j].price = temp.price;
			}
		}
	}
}

void TopDominating::Get_Skyline_Points()
{
	int i = 0, j;

	while (Restaurant[i].check)
	{
		for (j = i + 1; j < K; j++)   // this 2D loop is used for (distance,price), (distance,score), and (price, score)
		{
			if ((Restaurant[j].distance >= Restaurant[i].distance) && (Restaurant[j].price >= Restaurant[i].price))
				Restaurant[j].check = false;
		}

		/*for (j = i + 1; j < K; j++)   // this 3D loop is used for (distance,price,score)
		{
		if ((Restaurant[j].distance >= Restaurant[i].distance) && (Restaurant[j].price >= Restaurant[i].price) && (Restaurant[j].score >= Restaurant[i].score))
		Restaurant[j].check = false;
		}*/
	}

	for (i = 0; i < K; i++)
	{
		if (Restaurant[i].check)
			cout << Restaurant[i].distance << Restaurant[i].score << Restaurant[i].lat << Restaurant[i].lng << Restaurant[i].price << endl;
	}

}

int main()
{
	cout << "Enter the number of restaurants obtained after query ";
	int items, current_lat, current_lng;
	cin >> items >> current_lat >> current_lng;

	cout << "\n\n Enter the restaurants info: \n";
	for (int i = 0; i < items; i++)
	{
		cout << "Restaurant " << i << " : ";
		cin >> Restaurant[i].lat >> Restaurant[i].lng >> Restaurant[i].score >> Restaurant[i].price;
		cout << endl;
	}

	TopDominating obj(items, current_lat, current_lng);
	obj.Sort_Restaurant();
	obj.Get_Skyline_Points();

}


    © 2018 GitHub, Inc.
    Terms
    Privacy
    Security
    Status
    Help

    Contact GitHub
    API
    Training
    Shop
    Blog
    About

Press h to open a hovercard with more details.
