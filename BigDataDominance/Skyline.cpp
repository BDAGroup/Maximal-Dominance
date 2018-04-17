#include <iostream>
#include<cmath>

using namespace std;

class TopDominating {

public:
	struct Skyline 
	{
		int distance, lat, lng, score, price;
		bool check;

	};

	TopDominating(int, int, int);
	void Sort_Restaurant(Skyline &);
	void Get_Skyline_Points(Skyline &);

	int K;

private:
	Skyline Restaurant[K], temp;      // K is the number of restaurants after query

};

TopDominating ::TopDominating(int items, int MyLat, int MyLng)
{
	K = items;
	
	for (int i = 0; i < K; i++)
	{
		Restaurant[i].distance = sqrt(pow(Restaurant[i].lat - MyLat, 2) + pow(Restaurant[i].lng - MyLng, 2));
		Restaurant[i].check = true;

	}
	
}

void TopDominating::Sort_Restaurant(Skyline & Restaurant)
{
	for (int i = 0; i < K - 1; i++) 
	{
		for (int j = i + 1; j < K; j++) 
		{
			if (Restaurant[i].distance > Restaurant[j].distance)
			{
				temp = Restaurant[i].distance;
				Restaurant[i].distance = Restaurant[j].distance;
				Restaurant[j].distance = temp;
			}
		}
	}
}

void TopDominating::Get_Skyline_Points(Skyline & Restaurant)
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
			cout << Restaurant[i] << endl;
	}

}

int main()
{
	cout << "Enter the number of restaurants obtained after query ";
	int items, current_lat, current_lng;
	cin >> items;
	
	TopDominating obj(items, current_lat, current_lng);
	obj.Sort_Restaurant(Restaurant);
	obj.Get_Skyline_Points(Restaurant);

}
