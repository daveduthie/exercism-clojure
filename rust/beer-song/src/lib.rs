pub fn verse<'a>(num: u32) -> String {
    let (num_bef, num_aft, det, units_before, units_after) = match num {
        1 | 0 => ("1".to_string(), "no more".to_string(), "it", "bottle", "bottles"),
        _ => {
            (num.to_string(),
             (num - 1).to_string(),
             "one",
             "bottles",
             if num == 2 { "bottle" } else { "bottles" })
        }
    };

    match num {
        0 => {
            "No more bottles of beer on the wall, \
             no more bottles of beer.\n\
             Go to the store and buy some more, \
             99 bottles of beer on the wall.\n"
                    .to_string()
        }
        _ => {
            format!("{nb} {ub} of beer on the wall, \
                     {nb} {ub} of beer.\n\
                     Take {det} down and pass it around, \
                     {na} {ua} of beer on the wall.\n",
                    nb = num_bef,
                    ub = units_before,
                    det = det,
                    na = num_aft,
                    ua = units_after)
        }
    }
}

pub fn sing(high: u32, low: u32) -> String {
    (low..(high + 1))
        .rev()
        .map(|x| verse(x))
        .collect::<Vec<String>>()
        .join("\n")
}
