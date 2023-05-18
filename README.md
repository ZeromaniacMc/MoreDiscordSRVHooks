# MoreDiscordSRVHooks - What is it?
MoreDiscordSRVHooks is a plugin for 1.19+ spigot/fork based minecraft servers.

# What does it do?
MDH is simply a plugin to fetch data and throw it another direction. Basically, it grabs data given by other
plugins (hooks from list below), such as AuctionGUI+ and forwards who started an auction, how much an item is put up for and how long the auction will run until it expires
to DiscordSRV in form of a pre-formatted embed controlled by MDH's own config files. This could look like so for example: 

![yBU9mU9](https://github.com/ZeromaniacMc/MoreDiscordSRVHooks/assets/94971971/13367ffb-b701-4735-bbf2-03a4c6a32876)

# Other features
- MDH comes with simple yet effective debugging which can be enabled for every hook seperately if needed.
- You can send embeds to multiple channels at the same time.
- MDH aims to run as async as possible to not impact any other proccesses on your server.
- Even images can be set via simple {placeholders} rather than using some funky urls or gibberish formatting.
- PAPI support makes the whole thing more dynamic.
- The 3 implemented condition types of "string", "hasPermission" and "number" let you fine tune when to (not) send an embed - stay hidden!
  A detailed explanation on how conditions work is provided in the [Wiki about conditions](https://github.com/ZeromaniacMc/MoreDiscordSRVHooks/wiki/2.-Conditions).

# What plugins are supported by MDH?
  - AuctionGUIPlus
  - PlayerShopGUIPlus
  - AngelChest
  - LiteBans (not bungee)
  - PlaceholderAPI
  - QuickShop (Not hikari)
  - PlayerWarps

# Is it hard to use?
No, not at all. As long as you run the latest versions of all dependencies and dependencies of dependencies, you will be just fine.
MDH is very anal about it's configs and will always try to keep configs and comments/user instructions as clear as possible.

# What does it need to run?
MDH depends on the presence of DiscordSRV and InteractiveChatDiscordSRVAddon (which has it's very own dependencies to run on top of that). 

# What's the status of the project?
You see, I started MDH while not really knowing much about java itself. I used it as medium to learn and make something cool at the same
time. However, as things happen in life, interest in maintaining it deminished after some personal occurences.
For a while, I was looking for a successor, but that never happened. So this is why I decided to make this piece of noob java trash plugin public,
in hopes someone might pick it up or shows interest in helping me maintain it - or just for contributions. 

# What type of contributions do you accept into master? Are there any never-finished todo's?
- Variable renames for clarity
- Reduce fallback defaults to one format rather than one for each hook and each embed
- Anything to comply with changes by plugins I hook into
- Spelling corrections
- Hook additions (reasonable amount of users - please don't bother writing hooks for plugins that entered the market just a week ago)

# Is there anything you will never allow into master?
- Backporting to any version earlier than 1.19
- Structural changes other than the defaults reduction

# Compiling and testing
Compiling requires java 17. Path is set to `/target/`. Note that `/libraries/` should contain the following 3 files in order to access them: 
![jePEOis](https://github.com/ZeromaniacMc/MoreDiscordSRVHooks/assets/94971971/ffd16626-363d-45db-8c43-9efc85b6d3ea)
If you do not own a copy of these plugins, you may be out of luck for compiling, but that should not stop you from contributing at other ends.

# Downloads
You can find all releases by me here: [Downloads](https://github.com/ZeromaniacMc/MoreDiscordSRVHooks/releases)
