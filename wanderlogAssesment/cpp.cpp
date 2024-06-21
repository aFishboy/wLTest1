#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'groupTransactions' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts STRING_ARRAY transactions as parameter.
 */

vector<string> groupTransactions(vector<string> transactions) {
    // Write your code here
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string transactions_count_temp;
    getline(cin, transactions_count_temp);

    int transactions_count = stoi(ltrim(rtrim(transactions_count_temp)));

    vector<string> transactions(transactions_count);

    for (int i = 0; i < transactions_count; i++) {
        string transactions_item;
        getline(cin, transactions_item);

        transactions[i] = transactions_item;
    }

    vector<string> result = groupTransactions(transactions);

    for (int i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
