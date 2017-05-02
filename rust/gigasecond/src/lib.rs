extern crate chrono;

use chrono::*;

pub fn after(from: DateTime<chrono::UTC>) -> DateTime<chrono::UTC> {
    let gig = Duration::seconds(1_000_000_000);
    from + gig
}
