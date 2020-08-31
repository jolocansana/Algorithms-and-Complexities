#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Segment
{
    unsigned long long int L;
    unsigned long long int R;
};

bool comp(const Segment &s1, const Segment &s2)
{
    return s1.L < s2.L;
}

int main()
{  
    unsigned long long int M; // Length of the line
    unsigned long long int N; // Number of People
    cin >> M >> N;

    // Gets the people and their coverage
    vector<Segment> S(1);
    int a = 0;
    while (a < N)
    {
        cin >> S[0].L >> S[0].R;
        S.push_back(S[0]);
        a++;
    }
    
    // Sort S by increasing left endpoint.
    sort(S.begin() + 1, S.end(), comp);
   
    unsigned long long int curL = 1, rReach = 1;
    unsigned long long int i = 1;
    vector<Segment> segments;
    while (rReach < M)
    {
        // Choose the segment which L <= curL and extends the farthest 
        // to right.
        unsigned long long int newL = curL;
        unsigned long long int farthest = 0;    
        for ( ; i < S.size(); ++i)
        {
            if (S[i].L > curL+1)
                break;
            else if (S[i].R >= newL)
            {
                newL = S[i].R;
                farthest = i;
            }
        }
        if (farthest == 0)
            break;
        segments.push_back(S[farthest]);
        curL = rReach = newL;
    }
    if (rReach >= M)
    {
        cout << S.size()-1-segments.size() << endl;
    }
    else
        cout << "'Salem's Lot is doomed." << endl;

    return 0;
}