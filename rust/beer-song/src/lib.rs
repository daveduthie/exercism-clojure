fn unit(num: u32, capitalise: bool) -> String {
    match num {
        0 if capitalise => "No more bottles".to_string(),
        0 => "no more bottles".to_string(),
        1 => "1 bottle".to_string(),
        _ => num.to_string() + " bottles",
    }
}

fn determiner(num: u32) -> String {
    match num {
        1 => "it".to_string(),
        _ => "one".to_string(),
    }
}

pub fn verse(num: u32) -> String {
    let prefix = format!("{} of beer on the wall, \
                          {} of beer.\n",
                         unit(num, true),
                         unit(num, false));

    let suffix = match num {
        0 => {
            "Go to the store and buy some more, \
              99 bottles of beer on the wall.\n"
                    .to_string()
        }
        _ => {
            format!("Take {} down and pass it around, \
                      {} of beer on the wall.\n",
                    determiner(num),
                    unit(num - 1, false))
        }
    };

    prefix + &suffix
}

pub fn sing(high: u32, low: u32) -> String {
    (low..(high + 1))
        .rev()
        .map(|x| verse(x))
        .collect::<Vec<String>>()
        .join("\n")
}
