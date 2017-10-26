#include "boost/date_time/posix_time/posix_time.hpp"

using namespace boost::posix_time;

namespace gigasecond
{
  ptime advance(ptime from)
  {
    return from + seconds(1000000000);
  }
}
