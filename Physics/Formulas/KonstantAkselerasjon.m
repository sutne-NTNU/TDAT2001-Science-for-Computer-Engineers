function res = KonstantAkselerasjon(s, s_0, v_0, t, a)
if s == 0
	res = s_0 + v_0*t + (1*a*t^2 / 2);
elseif a == 0
	res = abs(2*(s - s_0 - (v_0*t)) / t^2);
elseif t == 0
	res = sqrt(2*(s - s_0 - (v_0*t)) / a);
elseif v_0 == 0
	res = (s - s_0 - (1*a*t^2 / 2))/t;
elseif s_0 == 0
	res = s - v_0*t - (1*a*t^2 / 2);
end
end

