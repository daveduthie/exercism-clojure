pub fn reply(words: &str) -> &str {
    match words {
        "" => "Fine. Be that way!",
        _ if words.to_uppercase() == words => "Whoa, chill out!",
        _ if words.ends_with("?") => "Sure.",
        _ => "Whatever.",
    }
}
