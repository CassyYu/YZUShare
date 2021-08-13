#include <iostream>
#include <vector>
using namespace std;
int main() {
  int q;
  cin >> q;
  while (q--) {
    int n;
    cin >> n;
    vector<int> v1(n), v2(n);
    for (int i = 0; i < n; ++i) cin >> v1[i];
    int sum = 0;
    for (int i = 0; i < n; ++i) {
      cin >> v2[i];
      sum += v2[i] - v1[i];
    }
    vector<int> ans1, ans2;
    for (int i = 0; i < n; ++i) {
      if (v1[i] < v2[i]) {
        int t = v2[i] - v1[i];
        while (t--) ans1.push_back(i+1);
      }
      if (v1[i] > v2[i]) {
        int t = v1[i] - v2[i];
        while (t--) ans2.push_back(i+1);
      }
    }
    if (ans1.size() != ans2.size()) {
      cout << -1 << endl;
    } else {
      cout << ans1.size() << endl;
      for (int i = 0; i < ans1.size(); ++i) {
        cout << ans2[i] << " " << ans1[i] << endl;
      }
    }
  }
  return 0;
}