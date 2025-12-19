package com.routine.tracker;

import java.util.Calendar;

public class RoutineSchedule {

    public RoutineActivity getActivity(int dayOfWeek, int timeInMinutes) {
        switch (dayOfWeek) {
            case Calendar.MONDAY:
                return getMondayActivity(timeInMinutes);
            case Calendar.TUESDAY:
                return getTuesdayActivity(timeInMinutes);
            case Calendar.WEDNESDAY:
                return getWednesdayActivity(timeInMinutes);
            case Calendar.THURSDAY:
                return getThursdayActivity(timeInMinutes);
            case Calendar.FRIDAY:
                return getFridayActivity(timeInMinutes);
            case Calendar.SATURDAY:
                return getSaturdayActivity(timeInMinutes);
            case Calendar.SUNDAY:
                return getSundayActivity(timeInMinutes);
            default:
                return new RoutineActivity("❓ Unknown Day", "");
        }
    }

    private RoutineActivity getMondayActivity(int time) {
        // Sunday Sleep recovery
        if (time >= toMinutes(0,0) && time < toMinutes(0, 30)) {
            return new RoutineActivity("🌙 Wind Down", "No phone • Read • Relax • Sunday Recovery");
        } else if (time >= toMinutes(0,30) && time < toMinutes(9, 0)) {
            return new RoutineActivity("😴 Sleep Time", "Rest & recover for Monday");
        }
        // Monday Day routine
        if (time >= toMinutes(9, 0) && time < toMinutes(9, 15)) {
            return new RoutineActivity("🌅 Morning Routine", "Face wash • Hydrate • Coffee ☕");
        } else if (time >= toMinutes(9, 15) && time < toMinutes(10, 0)) {
            return new RoutineActivity("🧠 Planning Time", "Outline tasks & set priorities");
        } else if (time >= toMinutes(10, 0) && time < toMinutes(10, 30)) {
            return new RoutineActivity("👔 Get Ready", "GRWM • Get into work mode");
        } else if (time >= toMinutes(10, 30) && time < toMinutes(11, 0)) {
            return new RoutineActivity("🚶 Commute", "Walk to office • Fresh start");
        } else if (time >= toMinutes(11, 0) && time < toMinutes(20, 0)) {
            return new RoutineActivity("💼 Work Time", "Deep focus at the office");
        } else if (time >= toMinutes(20, 0) && time < toMinutes(20, 30)) {
            return new RoutineActivity("🏠 Heading Home", "Commute back & unwind");
        } else if (time >= toMinutes(20, 30) && time < toMinutes(21, 0)) {
            return new RoutineActivity("😌 Decompress", "Relax • Buffer time");
        } else if (time >= toMinutes(21, 0) && time < toMinutes(21, 30)) {
            return new RoutineActivity("🍽 Dinner Time", "Paneer meal + protein shake");
        } else if (time >= toMinutes(21, 30) && time < toMinutes(23, 0)) {
            return new RoutineActivity("📚 Study Session", "90 mins • New concepts & notes");
        } else if (time >= toMinutes(23, 0) && time <= toMinutes(24, 0)) {
            return new RoutineActivity("🎮 Entertainment", "Game • Anime • Chill");
        }
        return new RoutineActivity("😴 Sleep Time", "Rest & recover for tomorrow");
    }

    private RoutineActivity getTuesdayActivity(int time) {
        // Monday Sleep recovery
        if (time >= toMinutes(0,0) && time < toMinutes(1, 0)) {
            return new RoutineActivity("🎮 Entertainment", "Game • Anime • Chill");
        } else if (time >= toMinutes(1, 0) && time < toMinutes(1, 30)) {
            return new RoutineActivity("🌙 Wind Down", "No phone • Read • Relax");
        } else if (time >= toMinutes(1,30) && time < toMinutes(9, 0)) {
            return new RoutineActivity("😴 Sleep Time", "Rest & recover for Tuesday");
        }
        // Tuesday Day Routine
        if (time >= toMinutes(9, 0) && time < toMinutes(9, 15)) {
            return new RoutineActivity("🌅 Morning Routine", "Face wash • Hydrate • Coffee ☕");
        } else if (time >= toMinutes(9, 15) && time < toMinutes(10, 0)) {
            return new RoutineActivity("🧠 Planning Time", "Plan your wins for today");
        } else if (time >= toMinutes(10, 0) && time < toMinutes(10, 30)) {
            return new RoutineActivity("👔 Get Ready", "GRWM • Get moving");
        } else if (time >= toMinutes(10, 30) && time < toMinutes(11, 0)) {
            return new RoutineActivity("🚶 Commute", "Walk to office");
        } else if (time >= toMinutes(11, 0) && time < toMinutes(20, 0)) {
            return new RoutineActivity("💼 Work Time", "Office • Stay productive");
        } else if (time >= toMinutes(20, 0) && time < toMinutes(20, 30)) {
            return new RoutineActivity("🏠 Heading Home", "Commute back");
        } else if (time >= toMinutes(20, 30) && time < toMinutes(22, 0)) {
            return new RoutineActivity("🏋️ GYM Time", "Full workout • Push hard");
        } else if (time >= toMinutes(22, 0) && time < toMinutes(22, 30)) {
            return new RoutineActivity("🍽 Dinner Time", "Protein-focused meal");
        } else if (time >= toMinutes(22, 30) && time <= toMinutes(24, 0)) {
            return new RoutineActivity("🎮 Entertainment", "Game • Anime • Relax");
        }
        return new RoutineActivity("😴 Sleep Time", "Recovery sleep • Recharge");
    }

    private RoutineActivity getWednesdayActivity(int time) {
        // Tuesday Sleep Recovery
        if (time >= toMinutes(0, 0) && time < toMinutes(0, 30)) {
            return new RoutineActivity("😴 Sleep Time", "Relax | NO PHONE");
        } else if (time >= toMinutes(0, 30) && time < toMinutes(9, 0)) {
            return new RoutineActivity("😴 Sleep Time", "Recovery sleep • Recharge");
        }
        // Wednesday Day Routine
        if (time >= toMinutes(9, 0) && time < toMinutes(9, 15)) {
            return new RoutineActivity("🌅 Morning Routine", "Face wash • Hydrate • Coffee ☕");
        } else if (time >= toMinutes(9, 15) && time < toMinutes(10, 0)) {
            return new RoutineActivity("🧠 Planning Time", "Plan & prioritize");
        } else if (time >= toMinutes(10, 0) && time < toMinutes(10, 30)) {
            return new RoutineActivity("👔 Get Ready", "GRWM");
        } else if (time >= toMinutes(10, 30) && time < toMinutes(11, 0)) {
            return new RoutineActivity("🚶 Commute", "Walk to office");
        } else if (time >= toMinutes(11, 0) && time < toMinutes(20, 0)) {
            return new RoutineActivity("💼 Work Time", "Office focus block");
        } else if (time >= toMinutes(20, 0) && time < toMinutes(20, 30)) {
            return new RoutineActivity("🏠 Heading Home", "Commute back");
        } else if (time >= toMinutes(20, 30) && time < toMinutes(21, 0)) {
            return new RoutineActivity("😌 Relax", "Slow down & reset");
        } else if (time >= toMinutes(21, 0) && time < toMinutes(21, 30)) {
            return new RoutineActivity("🍽 Dinner Time", "Light & balanced meal");
        } else if (time >= toMinutes(21, 30) && time < toMinutes(23, 0)) {
            return new RoutineActivity("📚 Study Session", "90 mins • Strengthen fundamentals");
        } else if (time >= toMinutes(23, 0) && time <= toMinutes(24, 0)) {
            return new RoutineActivity("🎮 Entertainment", "Game • Anime");
        }
        return new RoutineActivity("😴 Sleep Time", "Rest & recover for tomorrow");
    }

    private RoutineActivity getThursdayActivity(int time) {
        // Wednesday Sleep Recovery
        if (time >= toMinutes(0, 0) && time < toMinutes(1, 0)) {
            return new RoutineActivity("🎮 Entertainment", "Game • Anime");
        } else if (time >= toMinutes(1, 0) && time < toMinutes(1, 30)) {
            return new RoutineActivity("🌙 Wind Down", "No phone • Book • Calm");
        } else if (time >= toMinutes(1, 30) && time < toMinutes(9, 0)) {
            return new RoutineActivity("😴 Sleep Time", "Rest & recover");
        }
        // Thursday Day Routine
        if (time >= toMinutes(9, 0) && time < toMinutes(9, 15)) {
            return new RoutineActivity("🌅 Morning Routine", "Face wash • Hydrate • Coffee ☕");
        } else if (time >= toMinutes(9, 15) && time < toMinutes(10, 0)) {
            return new RoutineActivity("🧠 Planning Time", "Daily plan & goals");
        } else if (time >= toMinutes(10, 0) && time < toMinutes(10, 30)) {
            return new RoutineActivity("👔 Get Ready", "GRWM");
        } else if (time >= toMinutes(10, 30) && time < toMinutes(11, 0)) {
            return new RoutineActivity("🚶 Commute", "Walk to office");
        } else if (time >= toMinutes(11, 0) && time < toMinutes(20, 0)) {
            return new RoutineActivity("💼 Work Time", "Office productivity");
        } else if (time >= toMinutes(20, 0) && time < toMinutes(20, 30)) {
            return new RoutineActivity("🏠 Heading Home", "Commute back");
        } else if (time >= toMinutes(20, 30) && time < toMinutes(22, 0)) {
            return new RoutineActivity("🏋️ GYM Time", "Strength & conditioning");
        } else if (time >= toMinutes(22, 0) && time < toMinutes(22, 30)) {
            return new RoutineActivity("🍽 Dinner Time", "Post-workout meal");
        } else if (time >= toMinutes(22, 30) && time <= toMinutes(24, 0)) {
            return new RoutineActivity("🎮 Entertainment", "Chill & recharge");
        }
        return new RoutineActivity("😴 Sleep Time", "Deep rest");
    }

    private RoutineActivity getFridayActivity(int time) {
        // Thursday Sleep Recovery
        if (time >= toMinutes(0, 0) && time < toMinutes(0, 30)) {
            return new RoutineActivity("🌙 Wind Down", "No phone • Read • Relax");
        } else if (time >= toMinutes(0, 30) && time < toMinutes(9, 0)) {
            return new RoutineActivity("😴 Sleep Time", "Deep rest");
        }
        // Friday Day Routine
        if (time >= toMinutes(9, 0) && time < toMinutes(9, 15)) {
            return new RoutineActivity("🌅 Morning Routine", "Face wash • Hydrate • Coffee ☕");
        } else if (time >= toMinutes(9, 15) && time < toMinutes(10, 0)) {
            return new RoutineActivity("🧠 Planning Time", "Wrap up the week strong");
        } else if (time >= toMinutes(10, 0) && time < toMinutes(10, 30)) {
            return new RoutineActivity("👔 Get Ready", "GRWM");
        } else if (time >= toMinutes(10, 30) && time < toMinutes(11, 0)) {
            return new RoutineActivity("🚶 Commute", "Walk to office");
        } else if (time >= toMinutes(11, 0) && time < toMinutes(20, 0)) {
            return new RoutineActivity("💼 Work Time", "Finish tasks & close loops");
        } else if (time >= toMinutes(20, 0) && time < toMinutes(20, 30)) {
            return new RoutineActivity("🏠 Heading Home", "Commute back");
        } else if (time >= toMinutes(20, 30) && time < toMinutes(21, 0)) {
            return new RoutineActivity("😌 Relax", "Ease into the night");
        } else if (time >= toMinutes(21, 0) && time < toMinutes(21, 30)) {
            return new RoutineActivity("🍽 Dinner Time", "Enjoy your meal");
        } else if (time >= toMinutes(21, 30) && time < toMinutes(23, 0)) {
            return new RoutineActivity("📚 Study Session", "Weekly review & consolidation");
        } else if (time >= toMinutes(23, 0) && time <= toMinutes(24, 0)) {
            return new RoutineActivity("🎉 Entertainment", "Game • Anime • Flex night!");
        }
        return new RoutineActivity("😴 Sleep Time", "Deep rest");
    }

    private RoutineActivity getSaturdayActivity(int time) {
        // Friday Sleep Recovery
        if (time >= toMinutes(0, 0) && time < toMinutes(2, 30)) {
            return new RoutineActivity("🎉 Late Night Chill", "Relax • Fun • Social");
        } else if (time >= toMinutes(2, 30) && time < toMinutes(10, 0)) {
            return new RoutineActivity("😴 Deep Sleep", "Hard cutoff • Full recovery");
        }
        // Saturday Day Routine
        if (time >= toMinutes(10, 0) && time < toMinutes(16, 0)) {
            return new RoutineActivity("✨ Free Time", "Rest • Friends • Personal time");
        } else if (time >= toMinutes(16, 0) && time < toMinutes(18, 0)) {
            return new RoutineActivity("🏋️ Gym Time", "Saturday workout • Push strong");
        } else if (time >= toMinutes(18, 0) && time <= toMinutes(24, 0)) {
            return new RoutineActivity("✨ Free Time", "Chill • Entertainment • Relax");
        }

        return new RoutineActivity("✨ Free Time", "");
    }

    private RoutineActivity getSundayActivity(int time) {
        // Saturday night cut-off at 1:30 am
        if (time >= toMinutes(0, 0) && time < toMinutes(0, 30)) {
            return new RoutineActivity("🌙 Wind Down", "No phone • Read • Relax");
        } else if (time >= toMinutes(0, 30) && time < toMinutes(9, 30)) {
            return new RoutineActivity("😴 Deep Sleep", "Saturday recovery sleep");
        }
        // Sunday Day Routine
        if (time >= toMinutes(9, 30) && time < toMinutes(14, 0)) {
            return new RoutineActivity("✨ Free Time", "Slow morning • Reset");
        } else if (time >= toMinutes(14, 0) && time < toMinutes(16, 0)) {
            return new RoutineActivity("📚 Deep Study", "Laser focus • No distractions");
        } else if (time >= toMinutes(16, 0) && time <= toMinutes(24, 0)) {
            return new RoutineActivity("✨ Free Time", "Relax • Prepare for Monday");
        }
        return new RoutineActivity("✨ Free Time", "");
    }

    private int toMinutes(int hour, int minute) {
        return hour * 60 + minute;
    }
}
