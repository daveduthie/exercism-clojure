#include <string>
#include <cctype>
#include "boost/algorithm/string/trim.hpp"

namespace bob
{
  bool shouting(std::string &speech)
  {
    bool has_upper = false;
    for (auto it = speech.cbegin(); it != speech.cend(); it++) {
      if (isupper(*it)) { has_upper = true; }
      if (islower(*it)) { return false; }
    }
    return has_upper;
  }

  bool question(std::string &speech)
  {
    if (speech.length() > 0 && speech.back() == '?') { return true; }
    return false;
  }

  std::string hey(std::string speech)
  {
    std::string s = boost::trim_copy(speech);
    if (shouting(s)) { return "Whoa, chill out!"; }
    if (question(s)) { return "Sure."; }
    if (s.empty()) { return "Fine. Be that way!"; }
    return "Whatever.";
  }
}
